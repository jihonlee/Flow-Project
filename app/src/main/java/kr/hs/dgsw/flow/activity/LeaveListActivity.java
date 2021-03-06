package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.adapter.LeaveListAdapter;
import kr.hs.dgsw.flow.database.DatabaseManager;
import kr.hs.dgsw.flow.model.Leave;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.hs.dgsw.flow.adapter.LeaveListAdapter;
import kr.hs.dgsw.flow.database.DatabaseManager;
import kr.hs.dgsw.flow.model.Leave;

public class LeaveListActivity extends AppCompatActivity {

    @BindView(R.id.leave_list_view) RecyclerView mLeaveListView;

    private LeaveListAdapter leaveListAdapter;

    @Override
    protected void onResume() {
        super.onResume();

        leaveListAdapter.clearData();

        for (Leave leave : DatabaseManager.selectAllLeave()) {
            leaveListAdapter.addItem(leave);
        }

        leaveListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_list);
        ButterKnife.bind(this);

        List<Leave> tempDataList = new ArrayList<>();

        leaveListAdapter = new LeaveListAdapter();

        mLeaveListView.setLayoutManager(new LinearLayoutManager(this));
        mLeaveListView.setAdapter(leaveListAdapter);
    }

    @OnClick(R.id.leave_list_apply)
    public void onClickApply(View view) {
        Intent intent = new Intent(this, LeaveActivity.class);
        startActivity(intent);
    }
}
