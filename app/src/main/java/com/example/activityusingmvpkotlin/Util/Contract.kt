package com.example.activityusingmvpkotlin.Util

interface Contract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(string: String?)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}