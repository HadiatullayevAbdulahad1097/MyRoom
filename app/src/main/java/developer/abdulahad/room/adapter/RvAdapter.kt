package developer.abdulahad.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.room.database.entity.Bilet
import developer.abdulahad.room.databinding.ItemRvBinding

class RvAdapter(var list: List<Bilet>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root){
        fun onBind(bilet : Bilet, position: Int) {
            itemRv.name.text = bilet.name.toString()
            itemRv.biletKodi.text = bilet.bilet_kodi.toString()
            itemRv.location.text = bilet.qayerga
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position] , position)
    }

    override fun getItemCount(): Int = list.size
}