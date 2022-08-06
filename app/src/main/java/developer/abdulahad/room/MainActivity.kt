package developer.abdulahad.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdulahad.room.adapter.RvAdapter
import developer.abdulahad.room.database.AppDataBase
import developer.abdulahad.room.database.entity.Bilet
import developer.abdulahad.room.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var bindind: ActivityMainBinding
    lateinit var appDataBase: AppDataBase
    lateinit var list: ArrayList<Bilet>
    lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        appDataBase = AppDataBase.getInstance(this)

        list = ArrayList()
        list.addAll(appDataBase.biletDuo().getAllBilet())
        rvAdapter = RvAdapter(list)
        bindind.apply {
            rv.adapter = rvAdapter
            btnSave.setOnClickListener {
                val bilet = Bilet(
                    name.text.toString(),
                    Random.nextInt(100),
                    location.text.toString()
                )

                appDataBase.biletDuo().addBilet(bilet)
                list.add(bilet)
                rvAdapter.notifyItemChanged(list.size-1)
            }
        }
    }
}