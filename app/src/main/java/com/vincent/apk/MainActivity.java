package com.vincent.apk;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vincent.apk.bean.ZhiHuMessageListBean;
import com.vincent.apk.network.ApiManager;
import com.vincent.apk.service.DownApkService;
import com.vincent.apk.utils.ToastUtils;
import com.vise.log.ViseLog;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_click_down_apk)
    Button btnClickDownApk;
    @BindView(R.id.et_apk_network_address)
    EditText et;
    @BindView(R.id.btn_get_zhihu_message)
    Button btnGetZhihuMessage;
    @BindView(R.id.rl_zhihu_message_list)
    RecyclerView rlZhihuMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void goDwon() {
        if (TextUtils.isEmpty(et.getText().toString().trim())) {
            ToastUtils.showLongToast("尚未输入");
        } else {
            Intent intent = new Intent(MainActivity.this, DownApkService.class);
            intent.putExtra("downApkUrl", et.getText().toString().trim());
            startService(intent);
        }
    }

    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showRationaleForCamera(PermissionRequest request) {
        showRationaleDialog("存储权限", request);
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onCameraDenied() {
        ToastUtils.showLongToast("拒绝权限，无法下载");
    }

    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onCameraNeverAskAgain() {
        ToastUtils.showLongToast("拒绝不提示");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

    @OnClick({R.id.btn_click_down_apk, R.id.btn_get_zhihu_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_click_down_apk:
                MainActivityPermissionsDispatcher.goDwonWithCheck(this);
                break;
            case R.id.btn_get_zhihu_message:
                Map<String,String> p = ApiManager.getBasicMap();
                ApiManager.getApiService()
                        .getZhiHuMessage(p)
                        .enqueue(new Callback<ZhiHuMessageListBean>() {
                            @Override
                            public void onResponse(Call<ZhiHuMessageListBean> call, Response<ZhiHuMessageListBean> response) {
                                ViseLog.d("--->"+response.body());

                            }

                            @Override
                            public void onFailure(Call<ZhiHuMessageListBean> call, Throwable t) {
                                ViseLog.d("error-->"+t.getMessage());
                            }
                        });
                break;
        }
    }
}
