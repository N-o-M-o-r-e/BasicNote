package com.sntthanh.notebasic.activities

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.sntthanh.notebasic.R
import com.sntthanh.notebasic.activities.TakeNote
import com.sntthanh.notebasic.activities.utils.HawkCommon
import com.sntthanh.notebasic.base.BaseActivityWithoutDataBiding
import com.sntthanh.notebasic.databinding.ActivityMainBinding
import com.sntthanh.notebasic.viewmodels.BaseNoteModel

class MainActivity : BaseActivityWithoutDataBiding<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var navController: NavController
    private lateinit var configuration: AppBarConfiguration

    private val model: BaseNoteModel by viewModels()

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(configuration)
    }

    override fun initData() {
        setSupportActionBar(binding.Toolbar)
        HawkCommon.putEventFirstApp(true)
    }

    override fun initView() {
        val navigationView: NavigationView = binding.NavigationView
        val headerView: View = navigationView.getHeaderView(0)
        val titleToolbar: MaterialToolbar = headerView.findViewById(R.id.titleToolbar)
        titleToolbar.title = "Hello,"+HawkCommon.getHawkName()

    }

    override fun listenLiveData() {
        setupMenu()
        setupNavigation()
        setupSearch()
    }

    override fun listeners() {
        binding.btnAdd.setOnClickListener {
            binding.viewAddItem.visibility = View.VISIBLE
//            navController.navigate(requireNotNull(R.id.Notes), null)
        }

        binding.viewAddItem.setOnClickListener {
            binding.viewAddItem.visibility = View.GONE
        }

        binding.TakeNote.setOnClickListener {
            val intent = Intent(this, TakeNote::class.java)
            startActivity(intent)
            binding.viewAddItem.visibility = View.GONE
        }

        binding.MakeList.setOnClickListener {
            val intent = Intent(this, MakeList::class.java)
            startActivity(intent)
            binding.viewAddItem.visibility = View.GONE
        }

    }



    private fun setupMenu() {
        val menu = binding.NavigationView.menu
        menu.add(0, R.id.Notes, 0, R.string.notes).setCheckable(true).setIcon(R.drawable.home)
        menu.add(1, R.id.Labels, 0, R.string.labels).setCheckable(true).setIcon(R.drawable.label)
        menu.add(2, R.id.Deleted, 0, R.string.deleted).setCheckable(true).setIcon(R.drawable.delete)
        menu.add(2, R.id.Archived, 0, R.string.archived).setCheckable(true).setIcon(R.drawable.archive)
        menu.add(3, R.id.Settings, 0, R.string.settings).setCheckable(true).setIcon(R.drawable.settings)
    }


    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        configuration = AppBarConfiguration(binding.NavigationView.menu, binding.DrawerLayout)
        setupActionBarWithNavController(navController, configuration)

        var fragmentIdToLoad: Int? = null
        binding.NavigationView.setNavigationItemSelectedListener { item ->
            fragmentIdToLoad = item.itemId
            binding.DrawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        clickNavigationItem()

        binding.DrawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerClosed(drawerView: View) {
                if (fragmentIdToLoad != null && navController.currentDestination?.id != fragmentIdToLoad) {
                    val options = navOptions {
                        launchSingleTop = true
//                        anim {
//                            exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
//                            enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
//                            popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
//                            popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
//                        }
                        popUpTo(navController.graph.startDestination) { inclusive = false }
                    }
                    navController.navigate(requireNotNull(fragmentIdToLoad), null, options)
                }
            }
        })

        navController.addOnDestinationChangedListener { _, destination, _ ->
            fragmentIdToLoad = destination.id
            binding.NavigationView.setCheckedItem(destination.id)
            handleDestinationChange(destination)
        }
    }

    private fun clickNavigationItem() {
        binding.Notes.setOnClickListener {
            navController.navigate(requireNotNull(R.id.Notes), null)
            binding.btnAdd.visibility = View.VISIBLE
            binding.Notes.setImageResource(R.drawable.ic_home_check)
            binding.Labels.setImageResource(R.drawable.ic_labels)
            binding.Archived.setImageResource(R.drawable.ic_archived)
            binding.Settings.setImageResource(R.drawable.ic_settings)
        }
        binding.Labels.setOnClickListener {
            navController.navigate(requireNotNull(R.id.Labels), null)
            binding.btnAdd.visibility = View.VISIBLE
            binding.Notes.setImageResource(R.drawable.ic_home)
            binding.Labels.setImageResource(R.drawable.ic_labels_check)
            binding.Archived.setImageResource(R.drawable.ic_archived)
            binding.Settings.setImageResource(R.drawable.ic_settings)
        }
        binding.Archived.setOnClickListener {
            navController.navigate(requireNotNull(R.id.Archived), null)
            binding.btnAdd.visibility = View.VISIBLE
            binding.Notes.setImageResource(R.drawable.ic_home)
            binding.Labels.setImageResource(R.drawable.ic_labels)
            binding.Archived.setImageResource(R.drawable.ic_archived_check)
            binding.Settings.setImageResource(R.drawable.ic_settings)
        }
        binding.Settings.setOnClickListener {
            navController.navigate(requireNotNull(R.id.Settings), null)
            binding.btnAdd.visibility = View.VISIBLE
            binding.Notes.setImageResource(R.drawable.ic_home)
            binding.Labels.setImageResource(R.drawable.ic_labels)
            binding.Archived.setImageResource(R.drawable.ic_archived)
            binding.Settings.setImageResource(R.drawable.ic_settings_check)
        }
    }


    private fun handleDestinationChange(destination: NavDestination) {
        if (destination.id == R.id.Notes
            ||destination.id == R.id.Archived
            ||destination.id == R.id.Labels
            ||destination.id == R.id.Settings
            ||destination.id == R.id.Search ) {
            binding.TakeNote.visibility = View.VISIBLE
            binding.MakeList.visibility = View.VISIBLE
        } else {
            binding.TakeNote.visibility = View.GONE
            binding.MakeList.visibility = View.GONE
        }

        binding.EnterSearchKeyword.isVisible = (destination.id == R.id.Search)
    }

    private fun setupSearch() {
        binding.EnterSearchKeyword.setText(model.keyword)
        binding.EnterSearchKeyword.doAfterTextChanged { text ->
            model.keyword = requireNotNull(text).trim().toString()
        }
    }
}