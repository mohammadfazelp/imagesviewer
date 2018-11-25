package com.faz.imagesviewer.ui.home.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.faz.imagesviewer.R
import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.ui.base.view.BaseActivity
import com.faz.imagesviewer.ui.home.interactor.HomeInteractor
import com.faz.imagesviewer.ui.home.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : BaseActivity() , HomeView {

    @Inject
    internal lateinit var presenter: HomePresenter<HomeView, HomeInteractor>

    private lateinit var recyclerView : RecyclerView

    private lateinit var swipeContainer : SwipeRefreshLayout

    private lateinit var linearLayoutManager: StaggeredGridLayoutManager

    private lateinit var adapter: RecyclerAdapter

    private var limit :Int = 5

    private var offset: Int=0

    private var imageList : ArrayList<ImageResponse>  = arrayListOf()

    override fun addData(images: ArrayList<ImageResponse>) {
        Log.v("images",images.toString())
        imageList.addAll(images)
        adapter.notifyDataSetChanged()
    }

    override fun showError(err: Throwable) {
        if(err.message!=null)
            Log.e("images_err",err.message)
    }

    override fun onDestroy() {
        presenter.onDetach()
        adapter.clearCache()
        super.onDestroy()
    }

    override fun bindLayout(): Int {
        return R.layout.activity_home
    }

    override fun initView(savedInstanceState: Bundle, contentView: View) {
    }

    override fun processLogic() {

        presenter.onAttach(this)
        linearLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView = findViewById(R.id.recyclerView)
        swipeContainer = findViewById(R.id.swipeContainer)

        swipeContainer.setOnRefreshListener {
            adapter.clear()
            fetchImages(0)
            swipeContainer.isRefreshing = false
        }
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(imageList,this)
        recyclerView.adapter = adapter
        presenter.onServerGetImages()
    }

    private fun fetchImages(offset : Int){
        presenter.onServerGetImages()
    }

    override fun onClick(v: View?) {
    }

    override fun initData(bundle: Bundle?) {
    }
}
