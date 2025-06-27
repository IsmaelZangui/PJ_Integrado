package persistencia;

import dominio.Anuncio;
import dominio.ChaveUtilizador;
import dominio.PerfilChave;
import dominio.Restricao;
import dominio.RestricaoChave;
import dominio.Utilizador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TransactionRequiredException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.io.Serializable;
import java.net.ConnectException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientConnectionException;

@Stateless
public class AcessoDados implements Serializable {

    @PersistenceContext(unitName = "unity")
    private EntityManager em;

    @Transactional
    public String registar_utilizador(Utilizador util) {
        try {
            if (util == null) {
                return "Informe os seus Dados";
            } else {
                if (util.getNome().isBlank() && util.getEmail().isBlank() && util.getSenha().isBlank()) {
                    return "Informe correctamente os Dados! Existem Dados Vazios";
                } else {
                    Long count = em.createQuery("SELECT COUNT(u) FROM Utilizador u WHERE u.nome = :nome", Long.class)
                            .setParameter("nome", util.getNome())
                            .getSingleResult();
                    Long count1 = em.createQuery("SELECT COUNT(u) FROM Utilizador u WHERE u.email = :email", Long.class)
                            .setParameter("email", util.getEmail())
                            .getSingleResult();

                    if (count > 0) {
                        return "Erro: Já existe um utilizador com este nome ('" + util.getNome() + "'). Por favor, escolha outro.";
                    }
                    if (count1 > 0) {
                        return "Erro: Já existe um utilizador com este email ('" + util.getEmail() + "'). Por favor, escolha outro.";
                    }
                    em.persist(util);
                    return "ok";
                }
            }
        } catch (ConstraintViolationException e) {
            StringBuilder sb = new StringBuilder("Erro de validação do utilizador: ");
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                sb.append(violation.getPropertyPath()).append(" ").append(violation.getMessage()).append("; ");
            }
            System.err.println("DETALHES DA VIOLAÇÃO (Bean Validation): " + sb.toString());
            return sb.toString();
        } catch (EntityExistsException e) {
            // Geralmente para IDs duplicados quando o ID é gerado manualmente ou em `@Id` com `@GeneratedValue`
            System.err.println("ERRO: Entidade já existe. " + e.getMessage());
            return ("Erro: Utilizador já existe ou ID duplicado. " + e.getMessage());
        } catch (PersistenceException e) {
            System.err.println("ERRO DE PERSISTÊNCIA INESPERADO: " + e.getMessage()); // Loga a mensagem da PersistenceException
            e.printStackTrace(); // Imprima o stack trace completo para depuração
            Throwable currentCause = e; // Comece com a PersistenceException
            String errorMessage = "Erro desconhecido.";
            // Itere sobre a cadeia de causas para encontrar a exceção mais relevante
            while (currentCause != null) {
                if (currentCause instanceof ConnectException) {
                    errorMessage = "Erro de conexão: O servidor inacessível Verifica a sua (Rede).";
                    break; // Encontramos a causa mais específica de conexão
                } else if (currentCause instanceof SQLNonTransientConnectionException) {
                    errorMessage = "Erro de conexão: Verifica a sua (Rede). ";
                    break;
                } else if (currentCause instanceof SQLException) {
                    SQLException sqlEx = (SQLException) currentCause;
                    if (sqlEx.getSQLState() != null && sqlEx.getSQLState().startsWith("08")) {
                        // SQLState "08XXX" indica problemas de conexão
                        errorMessage = "Erro de comunicação com o banco de dados (rede ou BD inacessível). Detalhes: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        break;
                    } else if (sqlEx instanceof SQLIntegrityConstraintViolationException) {
                        // Este bloco trata violações de unicidade/integridade do BD, caso não tenham sido pegas pelo count ou EntityExistsException
                        SQLIntegrityConstraintViolationException sqlIntegrityEx = (SQLIntegrityConstraintViolationException) sqlEx;
                        if (sqlIntegrityEx.getErrorCode() == 1062) { // MySQL: Duplicate entry
                            if (sqlIntegrityEx.getMessage().contains("for key 'nome'")) {
                                errorMessage = "Erro: Já existe um utilizador com este nome. Por favor, escolha outro.";
                            } else if (sqlIntegrityEx.getMessage().contains("for key 'email'")) {
                                errorMessage = "Erro: Já existe um utilizador com este email. Por favor, escolha outro.";
                            } else {
                                errorMessage = "Erro: Violação de restrição, provavelmente esteja Inserir um Dados já existente. " + sqlIntegrityEx.getMessage();
                            }
                        } else {
                            errorMessage = "Erro de integridade do banco de dados (SQL Code: " + sqlIntegrityEx.getErrorCode() + "): " + sqlIntegrityEx.getMessage();
                        }
                        break;
                    } else {
                        // Outras SQL exceptions não relacionadas à conexão
                        errorMessage = "Erro SQL inesperado: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        // Não break, continue procurando uma causa mais profunda se for um erro genérico
                    }
                }
                currentCause = currentCause.getCause(); // Vá para a próxima causa na cadeia
            }
            return errorMessage; // Retorna a mensagem mais específica encontrada

        } catch (Exception e) {
            System.err.println("OCORREU UM ERRO INESPERADO: " + e.getMessage());
            e.printStackTrace(); // Sempre imprima o stack trace para erros inesperados
            return ("Ocorreu um erro inesperado ao salvar/atualizar o utilizador: " + e.getMessage());
        }
    }

    public String postar_mensagem(Anuncio anuncio, int restricao, int id_utilizador) {
        Restricao res;
        try {
            if (anuncio == null) {
                return "Informe os dados do seu Anuncio";
            } else {
                if (anuncio.getTitulo().isBlank() && anuncio.getMensagem().isBlank() && anuncio.getData().isBlank() && anuncio.getDataFim().isBlank()) {
                    return "Informe correctamente os Dados! Existem Dados Vazios";
                } else {
                    res = em.find(Restricao.class, restricao);
                    Utilizador utili = em.find(Utilizador.class, id_utilizador);

                    if (res != null && utili != null) {
                        //return "Encontrado"+res.getTipo();
                        anuncio.setIdRestricao(res);
                        anuncio.setUtilizador(utili);
                        em.persist(anuncio);
                    }
                }
            }
        } catch (ConstraintViolationException e) {
            return ("DETALHES DA VIOLAÇÃO INTEGRIDADE");
        } catch (EntityExistsException e) {
            // Geralmente para IDs duplicados quando o ID é gerado manualmente ou em `@Id` com `@GeneratedValue`
            System.err.println("ERRO: Entidade já existe. ");
            return ("Erro: Anuncio já existe ou Identificador já está sendo Utilizado. ");
        } catch (PersistenceException e) {
            Throwable currentCause = e; // Comece com a PersistenceException
            String errorMessage = "Erro desconhecido.";
            // Itere sobre a cadeia de causas para encontrar a exceção mais relevante
            while (currentCause != null) {
                if (currentCause instanceof ConnectException) {
                    errorMessage = "Erro de conexão: O servidor inacessível Verifica a sua (Rede).";
                    break; // Encontramos a causa mais específica de conexão
                } else if (currentCause instanceof SQLNonTransientConnectionException) {
                    errorMessage = "Erro de conexão: Verifica a sua (Rede). ";
                    break;
                } else if (currentCause instanceof SQLException) {
                    SQLException sqlEx = (SQLException) currentCause;
                    if (sqlEx.getSQLState() != null && sqlEx.getSQLState().startsWith("08")) {
                        // SQLState "08XXX" indica problemas de conexão
                        errorMessage = "Erro de comunicação com o banco de dados (rede ou BD inacessível). Detalhes: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        break;
                    }
                }
                currentCause = currentCause.getCause(); // Vá para a próxima causa na cadeia
            }
            return errorMessage; // Retorna a mensagem mais específica encontrada

        } catch (Exception e) {
            System.err.println("OCORREU UM ERRO INESPERADO: " + e.getMessage());
            e.printStackTrace(); // Sempre imprima o stack trace para erros inesperados
            return ("Ocorreu um erro inesperado ao salvar/atualizar o utilizador: " + e.getMessage());
        }
        return res.getId().toString();
    }

    public String criar_chave(PerfilChave chave, int id_utilizador) {
        try {
            if (chave == null) {
                return "Informe os dados correctos";
            } else {
                if (chave.getChave().isBlank() && chave.getValor().isBlank()) {
                    return "Informe correctamente os Dados! Existem Dados Vazios";
                } else {
                    List<PerfilChave> perfis = em.createQuery("SELECT pf FROM PerfilChave pf WHERE pf.chave =:chave and pf.valor =:valor", PerfilChave.class)
                            .setParameter("chave", chave.getChave())
                            .setParameter("valor", chave.getValor()).getResultList();
                    Utilizador util = em.find(Utilizador.class, id_utilizador);
                    if (!perfis.isEmpty()) {
                        if (util != null) {
                            ChaveUtilizador chaveUtilizador = new ChaveUtilizador();
                            chaveUtilizador.setIdChave(perfis.get(0));
                            chaveUtilizador.setIdUtilizador(util);
                            em.persist(chaveUtilizador);
                            return "ok";
                        } else {
                            return "Utilizador não Encontrado";
                        }
                    } else {
                        em.persist(chave);
                        em.flush();
                        ChaveUtilizador chaveUtilizador = new ChaveUtilizador();
                        chaveUtilizador.setIdChave(chave);
                        chaveUtilizador.setIdUtilizador(util);
                        em.persist(chaveUtilizador);
                        return "ok";
                        // return chave.getId().toString();
                        //return "Foi no ELSE";
                    }

                }
            }
        } catch (ConstraintViolationException e) {
            return ("DETALHES DA VIOLAÇÃO INTEGRIDADE");
        } catch (EntityExistsException e) {
            // Geralmente para IDs duplicados quando o ID é gerado manualmente ou em `@Id` com `@GeneratedValue`
            System.err.println("ERRO: Entidade já existe. ");
            return ("Erro: Anuncio já existe ou Identificador já está sendo Utilizado. ");
        } catch (PersistenceException e) {
            Throwable currentCause = e; // Comece com a PersistenceException
            String errorMessage = "Erro desconhecido.";
            // Itere sobre a cadeia de causas para encontrar a exceção mais relevante
            while (currentCause != null) {
                if (currentCause instanceof ConnectException) {
                    errorMessage = "Erro de conexão: O servidor inacessível Verifica a sua (Rede).";
                    break; // Encontramos a causa mais específica de conexão
                } else if (currentCause instanceof SQLNonTransientConnectionException) {
                    errorMessage = "Erro de conexão: Verifica a sua (Rede). ";
                    break;
                } else if (currentCause instanceof SQLException) {
                    SQLException sqlEx = (SQLException) currentCause;
                    if (sqlEx.getSQLState() != null && sqlEx.getSQLState().startsWith("08")) {
                        // SQLState "08XXX" indica problemas de conexão
                        errorMessage = "Erro de comunicação com o banco de dados (rede ou BD inacessível). Detalhes: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        break;
                    }
                }
                currentCause = currentCause.getCause(); // Vá para a próxima causa na cadeia
            }
            return errorMessage; // Retorna a mensagem mais específica encontrada

        } catch (Exception e) {
            System.err.println("OCORREU UM ERRO INESPERADO: " + e.getMessage());
            e.printStackTrace(); // Sempre imprima o stack trace para erros inesperados
            return ("Ocorreu um erro inesperado ao salvar/atualizar o utilizador: " + e.getMessage());
        }
//        return "ok";
    }

    public String criar_restricao(int id_restricao, int id_chave) {
        try {
            if (em.find(Restricao.class, id_restricao) != null && em.find(PerfilChave.class, id_chave) != null) {
                RestricaoChave restricao = new RestricaoChave();
                restricao.setIdChave(em.find(PerfilChave.class, id_chave));
                restricao.setIdRestricao(em.find(Restricao.class, id_restricao));
                em.persist(restricao);
                return "ok";
            } else {
                return "Falha ao criar Restrição";
            }
        } catch (ConstraintViolationException e) {
            return ("DETALHES DA VIOLAÇÃO INTEGRIDADE");
        } catch (EntityExistsException e) {
            // Geralmente para IDs duplicados quando o ID é gerado manualmente ou em `@Id` com `@GeneratedValue`
            System.err.println("ERRO: Entidade já existe. ");
            return ("Erro: Anuncio já existe ou Identificador já está sendo Utilizado. ");
        } catch (PersistenceException e) {
            Throwable currentCause = e; // Comece com a PersistenceException
            String errorMessage = "Erro desconhecido.";
            // Itere sobre a cadeia de causas para encontrar a exceção mais relevante
            while (currentCause != null) {
                if (currentCause instanceof ConnectException) {
                    errorMessage = "Erro de conexão: O servidor inacessível Verifica a sua (Rede).";
                    break; // Encontramos a causa mais específica de conexão
                } else if (currentCause instanceof SQLNonTransientConnectionException) {
                    errorMessage = "Erro de conexão: Verifica a sua (Rede). ";
                    break;
                } else if (currentCause instanceof SQLException) {
                    SQLException sqlEx = (SQLException) currentCause;
                    if (sqlEx.getSQLState() != null && sqlEx.getSQLState().startsWith("08")) {
                        // SQLState "08XXX" indica problemas de conexão
                        errorMessage = "Erro de comunicação com o banco de dados (rede ou BD inacessível). Detalhes: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        break;
                    }
                }
                currentCause = currentCause.getCause(); // Vá para a próxima causa na cadeia
            }
            return errorMessage; // Retorna a mensagem mais específica encontrada
        } catch (Exception e) {
            return ("Ocorreu um erro inesperado");
        }
    }

    public List<Anuncio> descentralizada(int utilizador) {
        List<Anuncio> listaD = null;
        List<Anuncio> listaC = null;
        try {
            listaD = em.createQuery("SELECT an FROM Anuncio an WHERE an.modo =:modo and an.utilizador.id !=:utilizador", Anuncio.class) // ATENÇÃO AQUI: an.utilizador.id
                    .setParameter("modo", "D")
                    .setParameter("utilizador", utilizador)
                    .getResultList();

            listaC = em.createQuery("SELECT an FROM Anuncio an WHERE an.modo =:modo and an.utilizador.id !=:utilizador", Anuncio.class) // ATENÇÃO AQUI: an.utilizador.id
                    .setParameter("modo", "C")
                    .setParameter("utilizador", utilizador)
                    .getResultList();
            
            if (!listaD.isEmpty()) {
                if(!listaC.isEmpty()){
                    for (int i = 0; i < listaC.size(); i++) {
                        ;
                    }
                }
                return listaC;
            } else {
                return null;
            }

        } catch (ConstraintViolationException e) {
            System.err.println("Erro de violação de restrição: " + e.getMessage());
            return null;
        } catch (EntityExistsException e) {
            System.err.println("ERRO: Entidade já existe. " + e.getMessage());
            return null;
        } catch (PersistenceException e) {
            Throwable currentCause = e;
            String errorMessage = "Erro desconhecido de persistência.";
            while (currentCause != null) {
                if (currentCause instanceof ConnectException) {
                    errorMessage = "Erro de conexão: O servidor inacessível. Verifique a sua (Rede).";
                    break;
                } else if (currentCause instanceof SQLNonTransientConnectionException) {
                    errorMessage = "Erro de conexão: Verifique a sua (Rede). ";
                    break;
                } else if (currentCause instanceof SQLException) {
                    SQLException sqlEx = (SQLException) currentCause;
                    if (sqlEx.getSQLState() != null && sqlEx.getSQLState().startsWith("08")) {
                        errorMessage = "Erro de comunicação com o banco de dados (rede ou BD inacessível). Detalhes: " + sqlEx.getMessage() + " (SQLState: " + sqlEx.getSQLState() + ", Code: " + sqlEx.getErrorCode() + ")";
                        break;
                    }
                }
                currentCause = currentCause.getCause();
            }
            System.err.println(errorMessage);
            return null;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            return null;
        }
    }
}
