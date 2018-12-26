package com.anu.androidbabycare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anu.androidbabycare.model.BabyDetails;
import com.anu.androidbabycare.model.BabyVaccine;
import com.anu.androidbabycare.model.HeightMaster;
import com.anu.androidbabycare.model.VaccineSchedule;
import com.anu.androidbabycare.model.WeightMaster;
import com.anu.androidbabycare.service.BabyDetailsService;
import com.anu.androidbabycare.service.BabyVaccineService;
import com.anu.androidbabycare.service.HeightMasterService;
import com.anu.androidbabycare.service.VaccinationScheduleService;
import com.anu.androidbabycare.service.WeightMasterService;
import com.anu.androidbabycare.utils.BabyDetailsUtils;
import com.anu.androidbabycare.utils.BabyVaccineUtils;
import com.anu.androidbabycare.utils.HeightMasterUtils;
import com.anu.androidbabycare.utils.VaccineScheduleUtils;
import com.anu.androidbabycare.utils.WeightMasterUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_age, et_phone;
    private Button resetbtn, savebtn;
    private BabyDetailsService babyDetailsService;
    private VaccinationScheduleService vaccinationScheduleService;
    private HeightMasterService heightMasterService;
    private WeightMasterService weightMasterService;
    private BabyVaccineService babyVaccineService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        et_phone = (EditText) findViewById(R.id.et_phone);
        //       resetbtn = (Button) findViewById(R.id.resetbtn);
        savebtn = (Button) findViewById(R.id.savebtn);

        babyDetailsService = BabyDetailsUtils.getBabyDetailsService();
        vaccinationScheduleService = VaccineScheduleUtils.getVaccineScheduleService();
        heightMasterService = HeightMasterUtils.getHeightMasterService();
        weightMasterService = WeightMasterUtils.getWeightMasterService();
        babyVaccineService = BabyVaccineUtils.getBabyVaccineService();



//        resetbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        "Hello",
//                        Toast.LENGTH_SHORT);
//
//                toast.show();
//            }
//        });
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BabyDetails babyDetails = new BabyDetails();

                babyDetails.setName(et_name.getText().toString());
                babyDetails.setPhoneNo(Long.parseLong(et_phone.getText().toString()));
                sendBabyDetails(babyDetails);
                getVaccineSchedule();
                getHeightMaster();
                getWeightMaster();


                BabyVaccine babyVaccine = new BabyVaccine();
                
                babyVaccine.setName("OPV");
                babyVaccine.setAge(1);
                sendBabyVaccine(babyVaccine);
                getBabyVaccine();

            }
        });


    }

    public void sendBabyDetails(BabyDetails babyDetails) {
        babyDetailsService.saveBabyDetails(babyDetails).enqueue(new Callback<BabyDetails>() {

            @Override
            public void onResponse(Call<BabyDetails> call, retrofit2.Response<BabyDetails> response) {
                BabyDetails resp = (BabyDetails) response.body();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "New Element ID is : " + resp.getId(),
                        Toast.LENGTH_SHORT);

                Log.i("TAG", "post submitted to API." + resp.getId());

                toast.show();

                getBabyDetails(resp.getId());
            }

            @Override
            public void onFailure(Call<BabyDetails> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Error while executing the service",
                        Toast.LENGTH_SHORT);

                toast.show();
            }

        });
    }

    public void getBabyDetails(Integer id) {
        babyDetailsService.getBabyDetails(id).enqueue(new Callback<BabyDetails>() {
            @Override
            public void onResponse(Call<BabyDetails> call, retrofit2.Response<BabyDetails> response) {
                BabyDetails resp = (BabyDetails) response.body();

                Toast.makeText(getApplicationContext(), "Baby Name is : " + resp.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BabyDetails> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error while executing the service", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getVaccineSchedule() {
        vaccinationScheduleService.getVaccineSchedule().enqueue(new Callback<List<VaccineSchedule>>() {
            @Override
            public void onResponse(Call<List<VaccineSchedule>> call, retrofit2.Response<List<VaccineSchedule>> response) {
                Toast.makeText(getApplicationContext(),"Vaccine Schedule Retrived Successfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<VaccineSchedule>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error while executing the service",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getHeightMaster(){
        heightMasterService.getHeightMaster().enqueue(new Callback<List<HeightMaster>>() {
            @Override
            public void onResponse(Call<List<HeightMaster>> call, Response<List<HeightMaster>> response) {
                Toast.makeText(getApplicationContext(),"Height details are successfully loaded",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<HeightMaster>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error while executing the service",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getWeightMaster(){
        weightMasterService.getWeightMaster().enqueue(new Callback<List<WeightMaster>>() {
            @Override
            public void onResponse(Call<List<WeightMaster>> call, Response<List<WeightMaster>> response) {
                Toast.makeText(getApplicationContext(),"weight details are successfully loaded",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<WeightMaster>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error while executing the service",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void sendBabyVaccine(BabyVaccine babyVaccine){
        babyVaccineService.saveBabyVaccine(babyVaccine).enqueue(new Callback<BabyVaccine>() {
            @Override
            public void onResponse(Call<BabyVaccine> call, Response<BabyVaccine> response) {
                BabyVaccine resp = (BabyVaccine)response.body();
                Toast.makeText(getApplicationContext(),"Vaccine is :" +resp.getName(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<BabyVaccine> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ERROR!!!!",Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void getBabyVaccine(){
        babyVaccineService.getBabyVaccine().enqueue(new Callback<List<BabyVaccine>>() {
            @Override
            public void onResponse(Call<List<BabyVaccine>> call, Response<List<BabyVaccine>> response) {
                Toast.makeText(getApplicationContext(),"Baby Vaccine Details are retrived",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<BabyVaccine>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ERROR!!!!",Toast.LENGTH_SHORT).show();

            }
        });
    }

}

