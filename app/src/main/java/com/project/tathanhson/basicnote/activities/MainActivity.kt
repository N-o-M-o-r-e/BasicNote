package com.project.tathanhson.basicnote.activities

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
import com.project.tathanhson.basicnote.base.BaseActivityWithoutDataBiding
import com.project.tathanhson.basicnote.R
import com.project.tathanhson.basicnote.databinding.ActivityMainBinding
import com.project.tathanhson.basicnote.viewmodels.BaseNoteModel

class MainActivity :
    BaseActivityWithoutDataBiding<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var navController: NavController
    private lateinit var configuration: AppBarConfiguration

    private val model: BaseNoteModel by viewModels()

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(configuration)
    }
    
    override fun initData() {
        
    }

    override fun initView() {
        setSupportActionBar(binding.Toolbar)
        setupMenu()
        setupNavigation()
        setupSearch()
    }

    override fun listenLiveData() {

    }

    override fun listeners() {
        binding.TakeNote.setOnClickListener {
            val intent = Intent(this, TakeNoteView::class.java)
            startActivity(intent)
        }
        binding.MakeList.setOnClickListener {
            val intent = Intent(this, MakeList::class.java)
            startActivity(intent)
        }
    }
    
    private fun setupMenu() {
        val menu = binding.NavigationView.menu
        menu.add(0, R.id.Notes, 0, getString(R.string.notes)).setCheckable(true).setIcon(R.drawable.home)
        menu.add(1, R.id.Labels, 0, getString(R.string.labels)).setCheckable(true).setIcon(R.drawable.label)
        menu.add(2, R.id.Deleted, 0, getString(R.string.deleted)).setCheckable(true).setIcon(R.drawable.delete)
        menu.add(2, R.id.Archived, 0, getString(R.string.archived)).setCheckable(true).setIcon(R.drawable.archive)
        menu.add(3, R.id.Settings, 0, getString(R.string.settings)).setCheckable(true).setIcon(R.drawable.settings)
    }


    private fun setupSearch() {
        binding.EnterSearchKeyword.setText(model.keyword)
        binding.EnterSearchKeyword.doAfterTextChanged { text ->
            model.keyword = requireNotNull(text).trim().toString()
        }
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

        binding.DrawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerClosed(drawerView: View) {
                if (fragmentIdToLoad != null && navController.currentDestination?.id != fragmentIdToLoad) {
                    val options = navOptions {
                        launchSingleTop = true
                        anim {
                            exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                            enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                            popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                            popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                        }
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

    private fun handleDestinationChange(destination: NavDestination) {
        if (destination.id == R.id.Notes) {
//            binding.TakeNote.show()
//            binding.MakeList.show()
        } else {
//            binding.TakeNote.hide()
//            binding.MakeList.hide()
        }

        binding.EnterSearchKeyword.isVisible = (destination.id == R.id.Search)
    }

}