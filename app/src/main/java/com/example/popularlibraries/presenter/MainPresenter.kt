package com.example.popularlibraries.presenter

import com.example.popularlibraries.interfaces.IScreens
import com.example.popularlibraries.interfaces.IUserListPresenter
import com.example.popularlibraries.interfaces.MainView
import com.example.popularlibraries.interfaces.UserItemView
import com.example.popularlibraries.model.CountersModel
import com.example.popularlibraries.model.GithubUser
import com.example.popularlibraries.repository.GithubUsersRepo
import com.example.popularlibraries.view.MainActivity
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }


}
