package com.example.popularlibraries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.R
import com.example.popularlibraries.adapters.UsersRVAdapter
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.interfaces.BackButtonListener
import com.example.popularlibraries.interfaces.UsersView
import com.example.popularlibraries.model.AndroidScreens
import com.example.popularlibraries.presenter.MainPresenter
import com.example.popularlibraries.presenter.UsersPresenter
import com.example.popularlibraries.repository.GithubUsersRepo
import com.example.popularlibraries.utils.BaseViewBindingFragment
import com.example.popularlibraries.сore.App
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

        companion object {
            fun newInstance() = UsersFragment()
        }

        val presenter: UsersPresenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), App.instance.router,AndroidScreens()) }
        var adapter: UsersRVAdapter? = null

        private var vb: FragmentUsersBinding? = null

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentUsersBinding.inflate(inflater, container, false).also {
                vb = it
            }.root

        override fun onDestroyView() {
            super.onDestroyView()
            vb = null
        }

        override fun init() {
            vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
            adapter = UsersRVAdapter(presenter.usersListPresenter)
            vb?.rvUsers?.adapter = adapter
        }

        override fun updateList() {
            adapter?.notifyDataSetChanged()
        }

          override fun backPressed() = presenter.backPressed()

}