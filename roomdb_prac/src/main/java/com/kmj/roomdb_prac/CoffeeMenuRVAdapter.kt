import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmj.roomdb_prac.CoffeeMenu
import com.kmj.roomdb_prac.databinding.CoffeeRvItemBinding

class CoffeeMenuRVAdapter(val coffeeMenus:ArrayList<CoffeeMenu>) :
    RecyclerView.Adapter<CoffeeMenuRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int =coffeeMenus.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CoffeeMenuRVAdapter.ViewHolder {
        val binding : CoffeeRvItemBinding = CoffeeRvItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("??", "onBindViewHolder : $position")
        val binding = (holder as ViewHolder).binding
        holder.bind(coffeeMenus[position])
        binding.recyclerItemRoot.setOnClickListener {
            Log.d("??", "${position}")
        }
    }


    inner class ViewHolder(val binding: CoffeeRvItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(coffeeMenus: CoffeeMenu){
            binding.coffeeImg.setImageResource(coffeeMenus.img!!) //coffee image
            binding.coffeeName.text = coffeeMenus.name // name
            binding.coffeePrice.text=coffeeMenus.price // price
        }
    }
}