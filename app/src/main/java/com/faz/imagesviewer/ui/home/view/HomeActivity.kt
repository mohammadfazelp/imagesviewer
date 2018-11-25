package com.faz.imagesviewer.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapter: RecyclerAdapter

    override fun addData(images: ArrayList<ImageResponse>) {
        Log.v("images",images.toString())
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
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = linearLayoutManager
        val photosList = arrayListOf<Photo>()
        /*for (i in 1..50) {
            val photo = Photo("","Date","Desc")
            photosList.add(photo)
        }*/
        adapter = RecyclerAdapter(photosList,this)
        recyclerView.adapter = adapter
    }

    override fun processLogic() {
        presenter.onAttach(this)
        presenter.onServerGetImages()
    }

    override fun onClick(v: View?) {
    }

    override fun initData(bundle: Bundle?) {
    }

}
