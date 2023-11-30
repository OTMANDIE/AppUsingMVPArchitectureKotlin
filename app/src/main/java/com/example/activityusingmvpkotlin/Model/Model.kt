package com.example.activityusingmvpkotlin.Model

import android.os.Handler
import com.example.activityusingmvpkotlin.Util.Contract
import java.util.*

class Model:Contract.Model{

    private var arraylist = listOf<String>("DIA_DEV_TS-09 : Acquérir les bases de développement Android",
        "DIA_DEV_TS-10 : Programmer en KOTLIN",
        "DIA_DEV_TS-11 : Découvrir la gestion de projet",
        "DIA_DEV_TS-12 : S’initier aux composants et modèle d’une application Android",
        "DIA_DEV_TS-13 : Développer des interfaces utilisateurs sous Android",
        "DIA_DEV_TS-14 : Elaborer une application Android sécurisée",
        "DIA_DEV_TS-15 : Découvrir les bases de développement des applications IOS",
        "DIA_DEV_TS-16 : Découvrir les bases de développement multiplateforme")

    override fun getNextCourse(listener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed(object :Runnable{
            override fun run() {
                listener!!.onFinished(getRandomString())
            }
        }, 2000)
    }

    private fun getRandomString(): String {
        var random = Random()
        val index :Int = random.nextInt(arraylist.size)
        return arraylist[index]
    }
}