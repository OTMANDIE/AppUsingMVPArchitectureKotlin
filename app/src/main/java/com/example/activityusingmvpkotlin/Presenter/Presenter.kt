package com.example.activityusingmvpkotlin.Presenter

import com.example.activityusingmvpkotlin.Model.Model
import com.example.activityusingmvpkotlin.Util.Contract

class Presenter(private var mainView: Contract.View?, val model: Model) : Contract.Presenter,
    Contract.Model.OnFinishedListener {


    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView?.setString(string)
            mainView?.hideProgress()
        }
    }

    override fun onButtonClick() {
        if (mainView != null) {
            mainView?.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView=null
    }
}