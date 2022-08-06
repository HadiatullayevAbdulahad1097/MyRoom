package developer.abdulahad.room.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Bilet {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var name:String? = null
    var bilet_kodi:Int? = null
    var qayerga:String? = null

    constructor(id: Int?, name: String?, bilet_kodi: Int?, qyerga: String?) {
        this.id = id
        this.name = name
        this.bilet_kodi = bilet_kodi
        this.qayerga = qyerga
    }

    constructor(name: String?, bilet_kodi: Int?, qyerga: String?) {
        this.name = name
        this.bilet_kodi = bilet_kodi
        this.qayerga = qyerga
    }

    constructor()
}