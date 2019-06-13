package in.indilabz.fillip_ecommerce.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.indilabz.fillip_ecommerce.INDIMaster;
import in.indilabz.fillip_ecommerce.R;
import in.indilabz.fillip_ecommerce.activity.SupportActivity;
import in.indilabz.fillip_ecommerce.helper.INDIPreferences;
import in.indilabz.fillip_ecommerce.rest.API;
import in.indilabz.fillip_ecommerce.rest.RetrofitInstance;
import in.indilabz.fillip_ecommerce.rest.RetrofitListener;


public abstract class INDIActivity extends AppCompatActivity implements RetrofitListener {

    private static FragmentTransaction fragmentTransaction;
    public static String fragmentTag;
    public static API api = RetrofitInstance.getSessionInstance().create(API.class);

    private int PICKER_CODE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void transactFragment(Fragment fragment) {

        fragmentTag = fragment.getClass().getName();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, fragmentTag);

        fragmentTransaction.addToBackStack(fragmentTag);
        fragmentTransaction.commitAllowingStateLoss();

    }

    public void destroyFragment() {

        getSupportFragmentManager().popBackStack();
    }

    public void changeActivity(Class<? extends AppCompatActivity> activity) {

        startActivity(new Intent(INDIMaster.applicationContext, activity));
    }

    public void startSupportActivity(String fragmentTag) {

        INDIPreferences.saveFragmentName(fragmentTag);
        startActivity(new Intent(INDIMaster.applicationContext, SupportActivity.class));
    }


}
