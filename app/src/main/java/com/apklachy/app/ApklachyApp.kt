package com.apklachy.app

import android.app.Application
import com.apklachy.app.data.AppDatabase
import com.apklachy.app.data.Repositorio

class ApklachyApp : Application() {

    val repositorio: Repositorio by lazy {
        Repositorio(AppDatabase.obtener(this).reparacionDao())
    }
}
