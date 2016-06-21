package me.crafter.android.zjsnviewer.ui.web;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.crafter.android.zjsnviewer.R;
import me.crafter.android.zjsnviewer.config.WebSite;
import me.crafter.android.zjsnviewer.ui.BaseFragmentActivity;

public class WebActivity extends BaseFragmentActivity{

    @BindView(R.id.rv_web)
    RecyclerView rv_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        ButterKnife.bind(this);

        setToolbarTitle(R.string.web_site);

        WebAdapter adapter = new WebAdapter(context, WebSite.getInstant().getList());
        rv_web.setLayoutManager(new LinearLayoutManager(context));
        rv_web.setAdapter(adapter);
    }
}
