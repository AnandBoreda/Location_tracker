package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ISDCodes extends AppCompatActivity {

    ListView listView,listView1;
    String[] listItem; TextView textView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isdcodes);


        String[] codes = {"7 840", "93", "358 18", "355", "213", "1 684", "376", "244", "1 264", "672", "1 268", "54", "374", "297", "247", "61", "672", "43", "994", "1 242", "973", "880", "1 246", "1 268", "375", "32", "501", "229", "1 441", "975", "591", "599 7", "387", "267", "55", "246", "1 284", "673", "359", "226", "95", "257", "855", "237", "1", "238", "599 3", "1 345", "236", "235", "64", "56", "86", "61", "61", "57", "269", "242", "243", "682", "506", "225", "385", "53", "53 99", "599 9", "357", "420", "243", "45", "246", "253", "1 767", "1 809", "670", "56", "593", "20", "503", "881 2", "882 13", "240", "291", "372", "251", "500", "298", "679", "358", "33", "596", "594", "689", "241", "220", "970", "995", "49", "233", "350", "30", "299", "1 473", "590", "1 671", "502", "44", "224", "245", "592", "509", "39", "504", "852", "36", "354", "91", "62", "98", "964", "353", "44", "972", "39", "225", "1 876", "81", "44", "962", "77", "254", "686", "381", "965", "996", "856", "371", "961", "266", "231", "218", "423", "370", "352", "853", "389", "261", "265", "60", "960", "223", "356", "692", "596", "222", "230", "262", "52", "691", "1 808", "373", "377", "976", "382", "1 664", "212", "258", "264", "674", "977", "31", "1 869", "687", "64", "505", "227", "234", "683", "672", "850", "1 670", "47", "968", "92", "680", "970", "507", "675", "595", "51", "63", "64", "48", "351", "1 787", "974", "242", "40", "7", "250", "599 4", "590", "290", "1 869", "1 758", "590", "508", "1 784", "685", "378", "239", "966", "221", "381", "248", "232", "65", "421", "386", "677", "252", "27", "82", "995 34", "211", "34", "94", "249", "597", "47 79", "268", "46", "41", "963", "886", "992", "255", "66", "670", "228", "690", "676", "1 868", "290 8", "216", "90", "993", "1 649", "688", "256", "380", "971", "44", "1", "598", "1 340", "998", "678", "58", "84", "1 808", "681", "970", "967", "260", "255", "263"};
         String[] countrynames = {"Abkhazia", "Afghanistan", "Aland Islands", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Ascension", "Australia", "Australian External Territories", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Barbuda", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bonaire", "Bosinia and Herzegovina", "Botswana", "Brazil", "British indian ocean Trritory", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Caribbean Netherlands", "Cayman Islands", "Central African Republic", "Chad", "Chatham Island, New Zealand", "Chile", "China", "Christmas Island", "Cocos(Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, Democratic Republic of the (Zaire)", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Guantanamo Bay", "Curacao", "Cyprus", "Czech Republic", "Democratic Republic of the congo", "Denmark", "Diego Garcia", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Easter Island", "Ecuador", "Egypt", "El salvador", "Ellipso", "EMSAT", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland islands", "Faroe Islands", "Fiji", "Finland", "France", "French Antilles", "French Guiana", "French Polynesia", "Gabon", "Gambia", "Gaza Strip", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See(Vatican City)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Midway Island, USA", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "Nevis", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk island", "North Korea", "Nothan Mariana Islands", "Norway", "Oman", "Pakisthan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paruguay", "Peru", "Philippines", "Pitcairn islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Republic of the congo", "Romania", "Russia", "Rwanda", "Saba", "Saint Barthelemy", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Sauidi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon islands", "Somalia", "South Africa", "South Korea", "South Ossetia", "South Sudan", "Spain", "SriLanka", "Sudan", "Suriname", "Svalbard", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tristan da Cunha", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "US Virgin Islands", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Wake Island, USA", "Wallis and Futuna", "West Bank", "Yemen", "Zambia", "Zanzibar", "Zimbabwe"};



        listView=(ListView)findViewById(R.id.lv);
        listView1=(ListView)findViewById(R.id.lv1);
//        listItem = getResources().getStringArray(R.array.array_technology);
//        //textView=(TextView)findViewById(R.id.textView);
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, countrynames);
        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                // TODO Auto-generated method stub
//                String value=adapter.getItem(position);
//                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
//
//            }
//        });

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, codes);
        listView1.setAdapter(adapt);

    }


}