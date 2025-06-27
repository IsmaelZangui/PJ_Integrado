package ao.uan.fc.dam.anunciosl.adapters;

public class ChaveAdapter extends RecyclerView.Adapter<ChaveAdapter.ChaveViewHolder> {

    private List<Chave> lista;
    private OnChaveRemoverListener listener;

    public interface OnChaveRemoverListener {
        void onRemoverClick(int position);
    }

    public ChaveAdapter(List<Chave> lista, OnChaveRemoverListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChaveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chave, parent, false);
        return new ChaveViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChaveViewHolder holder, int position) {
        Chave c = lista.get(position);
        holder.txtChave.setText(c.getChave());
        holder.txtValor.setText(c.getValor());
        holder.txtTipo.setText(c.isPadrao() ? "Padrão" : "Customizado");

        holder.btnRemover.setOnClickListener(v -> listener.onRemoverClick(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ChaveViewHolder extends RecyclerView.ViewHolder {
        TextView txtChave, txtValor, txtTipo;
        ImageView btnRemover;

        public ChaveViewHolder(@NonNull View itemView) {
            super(itemView);
            txtChave = itemView.findViewById(R.id.txtChave);
            txtValor = itemView.findViewById(R.id.txtValor);
            txtTipo = itemView.findViewById(R.id.txtTipo);
            btnRemover = itemView.findViewById(R.id.btnRemover);
        }
    }
}
