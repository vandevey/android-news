package fr.gobelins.edu.vandevelde.newsapp.adapters
import androidx.recyclerview.widget.RecyclerView

class ArticlesListAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NeighborItemBinding = NeighborItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        // Display Neighbour Name
        holder.binding.itemListName.text = neighbour.name
        val context = holder.binding.root.context

        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .skipMemoryCache(false)
            .into(holder.binding.itemListAvatar)

        holder.binding.itemListDeleteButton.setOnClickListener(View.OnClickListener {
            eventHandler.onDeleteNeibor(mNeighbours[position])
            notifyDataSetChanged()
        })
    }
}