package org.androidtown.covid19center.Mypage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.androidtown.covid19center.R;
import org.androidtown.covid19center.Server.AppManager;
import org.androidtown.covid19center.Server.QuestionnaireVO;
import org.androidtown.covid19center.Server.RetrofitClient;
import org.androidtown.covid19center.Server.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationCompleteActivity extends AppCompatActivity {

    private String name; // 예약자 이름
    private final String nameExplain = "예약자 : ";
    private String clinicDate; // 예약 날짜
    private final String clinicDateExplain = "예약 날짜 : ";
    private String clinicName; // 병원 이름
    private final String clinicNameExplain = "예약 병원 : ";
    private String clinicAddress; // 병원 주소
    private final String clinicAddressExplain = "병원 주소 : ";
    private String clinicCallNumber; // 병원 전화번호
    private final String clinicCallNumberExplain = "전화번호 : ";
    private boolean isVisited; // 1번 문항 트루 펄스
    private String nationalPlace; // 갔다온 장소
    private final String nationPlaceExplain = "방문국가/지역/장소 : ";
    private String nationalDate; // 입국 날짜
    private final String nationalDateExplain = "입국 날짜 : ";
    private boolean isContacted; // 2번 문항 트루 펄스
    private String contactRelationShip; // 본인과의 관계
    private final String contactRelationShipExplain = "본인과의 관계 : ";
    private String contactRelationDate; // 접촉 기간
    private final String relationDateExplain = "접촉 기간 : ";
    private boolean symptomCheck; // 증상
    private String symptomList; // 증상 리스트
    private final String symptomListExplain = "관련 증상 : ";
    private String symptomDate; // 증상 날짜
    private final String symptomDateExplain = "증상 날짜 : ";
    private boolean hasFever, hasMuscle_ache, hasCough, hasSputum, hasRunnyNose, hasDyspnea, hasSoreThroat;
    private StringBuffer symptoms;
    private ImageButton callButton;
    private TextView nameTextView;
    private TextView dateTextView;
    private TextView clinicNameTextView;
    private TextView clinicAddressTextView;
    private TextView clinicCallNumberTextView;
    private TextView nationalYesOrNoTextView;
    private TextView nationalPlaceTextView;
    private TextView nationalDateTextView;
    private TextView contactYesOrNoTextView;
    private TextView contactRelationTextView;
    private TextView contactDateTextView;
    private TextView symptomYesOrNoTextView;
    private TextView symptomListTextView;
    private TextView symptomDateTextView;
    private ImageButton backButton;

    private Button questionnaireModificationButton;

    private ArrayList<QuestionnaireVO> questionnaireVOArrayList;
    private ServiceApi serviceApi;
    private int sequence;
    private String toDoctor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reservation_complete);
        serviceApi = RetrofitClient.getClient().create(ServiceApi.class);

        setElement();
        //setIntentInfomation();

        getQuesionnaire();

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + clinicCallNumber));
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        questionnaireModificationButton = findViewById(R.id.modificationButton);

        questionnaireModificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("~~~~~","questionnaire button click");
                goToModificationActivity();
            }
        });
    }

    private void goToModificationActivity() {
        Log.d("~~~~~","goToModificationActivity");
        Intent intent = new Intent(this, QuestionnaireModificationActivity.class);
        startActivity(intent);

    }



    protected void getQuesionnaire() {
        Log.d("~~~~~", " getQuesionnaire");

        serviceApi.getQuesionnaireVO().enqueue(new Callback<List<QuestionnaireVO>>() {
            @Override
            public void onResponse(Call<List<QuestionnaireVO>> call, Response<List<QuestionnaireVO>> response) {

                questionnaireVOArrayList = AppManager.getInstance().getQuesionnaireVOArrayList();
                questionnaireVOArrayList.clear();

                int visited;
                int contact;
                int fever, muscle_ache, cough, sputum, runny_nose, dyspnea, sore_throat;

                /*
                String visited_detail, entrance_date;
                String contact_relationship, contact_period;
                String symptom_start_date, toDoctor;
                 */


                if (response.isSuccessful()) {
                    List<QuestionnaireVO> data = response.body();

                    Log.d("~~~~~", "questionnaireList 가져오기 성공");

                    sequence = data.get(data.size() -1).getSequence();
                    name = data.get(data.size() - 1).getUser_id();
                    visited = data.get(data.size() - 1).getVisited();
                    nationalPlace = data.get(data.size() - 1).getVisited_detail();
                    nationalDate = data.get(data.size() - 1).getEntrance_date();
                    contact = data.get(data.size() - 1).getContact();
                    contactRelationShip = data.get(data.size() - 1).getContact_relationship();
                    contactRelationDate = data.get(data.size() - 1).getContact_period();
                    fever = data.get(data.size() - 1).getFever();
                    muscle_ache = data.get(data.size() - 1).getMuscle_ache();
                    cough = data.get(data.size() - 1).getCough();
                    sputum = data.get(data.size() - 1).getSputum();
                    runny_nose = data.get(data.size() - 1).getRunny_nose();
                    dyspnea = data.get(data.size() - 1).getDyspnea();
                    sore_throat = data.get(data.size() - 1).getSore_throat();
                    symptomDate = data.get(data.size() - 1).getSymptom_start_date();
                    toDoctor = data.get(data.size() - 1).getToDoctor();


                    QuestionnaireVO questionnaireVO = new QuestionnaireVO(
                            sequence,
                            name,
                            visited,
                            nationalPlace,
                            nationalDate,
                            contact,
                            contactRelationShip,
                            contactRelationDate,
                            fever, muscle_ache, cough, sputum, runny_nose, dyspnea, sore_throat,
                            symptomDate,
                            toDoctor
                    );

                    questionnaireVOArrayList.add(questionnaireVO);

                    AppManager.getInstance().setQuestionnaireVOArrayList(questionnaireVOArrayList);



                    /** int -> boolean 형 변환
                     * radioButton check할 때는 boolean형 사용
                     *
                     */
                    isVisited = visited != 0;
                    isContacted = contact != 0;
                    hasFever = fever != 0;
                    hasMuscle_ache = muscle_ache != 0;
                    hasSputum = sputum != 0;
                    hasRunnyNose = runny_nose != 0;
                    hasDyspnea = dyspnea != 0;
                    hasSoreThroat = sore_throat != 0;


                    changeSymptomsToString();
                    setElementInfo();
                }
            }

            @Override
            public void onFailure(Call<List<QuestionnaireVO>> call, Throwable t) {
                Log.d("~~~~~", "실패: " + t);
                t.printStackTrace();
            }
        });

    }


    private void changeSymptomsToString(){
        symptoms = new StringBuffer();

        if(hasFever){
            symptoms.append("37.5도 이상 열,");
        }

        if(hasMuscle_ache){
            symptoms.append("전신통/근육통,");
        }

        if(hasCough){
            symptoms.append("기침,");
        }

        if(hasSputum){
            symptoms.append("가래,");
        }

        if(hasRunnyNose){
            symptoms.append("콧물,");
        }

        if(hasDyspnea){
            symptoms.append("호흡곤란,");
        }

        if(hasSoreThroat){
            symptoms.append("인후통,");
        }

        // 마지막 쉼표 지워주기
        if(symptoms.length() != 0){
            symptoms.deleteCharAt(symptoms.length()-1);
            symptomCheck = true;
        } else{
            symptomCheck = false;
        }

    }

    private void setElement(){
        backButton = findViewById(R.id.reservation_complete_backButton);
        nameTextView = findViewById(R.id.reservation_complete_userName);
        dateTextView = findViewById(R.id.reservation_complete_date);
        clinicNameTextView = findViewById(R.id.reservation_complete_clinicName);
        clinicAddressTextView = findViewById(R.id.reservation_complete_clinicAddress);
        clinicCallNumberTextView = findViewById(R.id.reservation_complete_callNumber);
        nationalYesOrNoTextView = findViewById(R.id.reservation_complete_national_check_textView);
        nationalPlaceTextView = findViewById(R.id.reservation_complete_national_true_textView);
        nationalDateTextView = findViewById(R.id.reservation_complete_national_true_date_textView);
        contactYesOrNoTextView = findViewById(R.id.reservation_complete_contact_check_textView);
        contactRelationTextView = findViewById(R.id.reservation_complete_contact_true_textView);
        contactDateTextView = findViewById(R.id.reservation_complete_contact_true_date_textView);
        symptomYesOrNoTextView = findViewById(R.id.reservation_complete_symptom_check_textView);
        symptomListTextView = findViewById(R.id.reservation_complete_symptom_true_textView);
        symptomDateTextView = findViewById(R.id.reservation_complete_symptom_date_textView);
        callButton = findViewById(R.id.reservation_complete_callButton);
    }

    private void setElementInfo(){
        dateTextView.setText(clinicDateExplain + clinicDate);
        clinicNameTextView.setText(clinicNameExplain + clinicName);
        clinicAddressTextView.setText(clinicAddressExplain + clinicAddress);
        clinicCallNumberTextView.setText(clinicCallNumberExplain + clinicCallNumber);

        if(isVisited == true){
            nationalYesOrNoTextView.setText("있음");
            nationalPlaceTextView.setText(nationPlaceExplain+nationalPlace);
            nationalDateTextView.setText(nationalDateExplain+nationalDate);
            nationalPlaceTextView.setVisibility(View.VISIBLE);
            nationalDateTextView.setVisibility(View.VISIBLE);
        } else{
            nationalYesOrNoTextView.setText("없음");
            nationalPlaceTextView.setVisibility(View.GONE);
            nationalDateTextView.setVisibility(View.GONE);
        }

        if(isContacted == true){
            contactYesOrNoTextView.setText("있음");
            contactRelationTextView.setText(contactRelationShipExplain+contactRelationShip);
            contactDateTextView.setText(relationDateExplain + contactRelationDate);
            contactRelationTextView.setVisibility(View.VISIBLE);
            contactDateTextView.setVisibility(View.VISIBLE);
        } else{
            contactYesOrNoTextView.setText("없음");
            contactRelationTextView.setVisibility(View.GONE);
            contactDateTextView.setVisibility(View.GONE);
        }

        if(symptomCheck == true){
            symptomYesOrNoTextView.setText("있음");
            symptomListTextView.setText(symptomListExplain + symptoms);
            symptomDateTextView.setText(symptomDateExplain + symptomDate);
            symptomListTextView.setVisibility(View.VISIBLE);
            symptomDateTextView.setVisibility(View.VISIBLE);
        } else{
            symptomYesOrNoTextView.setText("없음");
            symptomListTextView.setVisibility(View.GONE);
            symptomDateTextView.setVisibility(View.GONE);
        }
    }

    private void setIntentInfomation() {

        Intent intent = getIntent(); // 데이터 수신

        clinicDate = intent.getExtras().getString("clinicDate");
        clinicName = intent.getExtras().getString("clinicName");
        clinicAddress = intent.getExtras().getString("clinicAddress");
        clinicCallNumber = intent.getExtras().getString("clinicCallNumber");
        isVisited = intent.getExtras().getBoolean("nationalCheck");
        nationalPlace = intent.getExtras().getString("nationalPlace");
        nationalDate = intent.getExtras().getString("nationalDate");
        isContacted = intent.getExtras().getBoolean("contactCheck");
        contactRelationShip = intent.getExtras().getString("contactRelationShip");
        contactRelationDate = intent.getExtras().getString("contactRelationDate");
        symptomList = intent.getExtras().getString("symptomList");
        symptomDate = intent.getExtras().getString("symptomDate");
        if(symptomList.length() == 0){
            symptomCheck = false;
        } else{
            symptomCheck = true;
        }




    }

}
