package uz.eldor.testapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.eldor.testapp.R
import uz.eldor.testapp.model.ScienceModel



class SciencesAdapter(private val sciences:List<ScienceModel>, val  callback: SciencesAdapterCallback):RecyclerView.Adapter<SciencesAdapter.SciencesVH>() {
    inner class SciencesVH(view:View):RecyclerView.ViewHolder(view){
        private val textView:TextView = itemView.findViewById(R.id.text_view_title)
        fun bind(){
            itemView.setOnClickListener {
                callback.onClick(sciences[adapterPosition])
            }
            textView.text = sciences[adapterPosition].title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SciencesVH(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_sciences,parent,false))

    override fun onBindViewHolder(holder: SciencesVH, position: Int) = holder.bind()
    override fun getItemCount() = sciences.size
}
interface SciencesAdapterCallback{
    fun onClick(item:ScienceModel)
}