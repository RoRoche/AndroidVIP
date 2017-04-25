package fr.guddy.androidvip.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.guddy.androidvip.AndroidVIPApplication;
import fr.guddy.androidvip.R;
import fr.guddy.androidvip.di.AndroidVIPApplicationComponent;
import fr.guddy.androidvip.ui.main.di.MainComponent;
import fr.guddy.androidvip.ui.main.di.MainModule;

public class MainActivity
        extends MvpActivity<MvpMain.View, MvpMain.Presenter>
        implements MvpMain.View {

    //region Bound views
    @BindView(R.id.ActivityMain_EditText_A)
    EditText mEditTextA;
    @BindView(R.id.ActivityMain_EditText_B)
    EditText mEditTextB;
    @BindView(R.id.ActivityMain_TextViewResult)
    TextView mTextViewResult;
    @BindView(R.id.ActivityMain_ViewGroup_Content)
    ViewGroup mViewGroupContent;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    //endregion

    //region MvpActivity
    @NonNull
    @Override
    public MvpMain.Presenter createPresenter() {
        final AndroidVIPApplicationComponent lAndroidVIPApplicationComponent = AndroidVIPApplication.getInstance().getAndroidVIPApplicationComponent();
        final MainComponent lMainComponent = lAndroidVIPApplicationComponent.mainComponent(new MainModule());
        return lMainComponent.presenter();
    }
    //endregion

    //region User interaction
    @OnClick(R.id.ActivityMain_Button_Compute)
    public void onClickButtonCompute() {
        if (TextUtils.isEmpty(mEditTextA.getText())) {
            mEditTextA.setError(getString(R.string.should_type_number));
        }

        if (TextUtils.isEmpty(mEditTextB.getText())) {
            mEditTextB.setError(getString(R.string.should_type_number));
        }

        if (TextUtils.isEmpty(mEditTextA.getError()) && TextUtils.isEmpty(mEditTextB.getError())) {
            getPresenter().compute(
                    Integer.valueOf(mEditTextA.getText().toString()),
                    Integer.valueOf(mEditTextB.getText().toString())
            );
        }
    }
    //endregion

    //region MvpMain.View
    @Override
    public void onResult(final int pResult) {
        mTextViewResult.setText(String.valueOf(pResult));
    }

    @Override
    public void onFailure() {
        Snackbar.make(mViewGroupContent, R.string.an_error_occurred, Snackbar.LENGTH_LONG).show();
    }
    //endregion
}
