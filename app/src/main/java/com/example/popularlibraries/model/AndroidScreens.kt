package com.example.popularlibraries.model

import com.example.popularlibraries.interfaces.IScreens
import com.example.popularlibraries.view.OneUserFragment
import com.example.popularlibraries.view.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens: IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun userDeteils()= FragmentScreen { OneUserFragment.newInstance() }

}