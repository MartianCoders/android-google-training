package com.example.orarproiect;


import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecoderHTML extends AsyncTask<Void, Void, Void> {
    private final String URL_HTML_IMPORT_DATA = "https://www.cs.ubbcluj.ro/files/orar/2020-1/tabelar/MI2.html";
    private List<String> listImportRaw = new ArrayList<String>();

    private List<Ora> mondayData = new ArrayList<Ora>();

    DecoderHTML() {

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            this.decode();
        }
        catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private void decode() throws IOException, ParseException {
        org.jsoup.nodes.Document doc = Jsoup.connect(URL_HTML_IMPORT_DATA).get();
        org.jsoup.select.Elements rows = doc.select("tr");
        for (org.jsoup.nodes.Element row : rows) {
            org.jsoup.select.Elements columns = row.select("td");
            for (org.jsoup.nodes.Element column : columns)
                listImportRaw.add(column.text());
            this.dataFilter(listImportRaw);
            listImportRaw.clear();
        }
    }

    private void dataFilter(List<String> dataRaw) throws ParseException {
        if(!dataRaw.isEmpty()) {
            String[] hoursSplit = dataRaw.get(1).split("-");

            if (dataRaw.get(0).toLowerCase().equals("luni")) {
                Log.d("INTRA", "DA");
                Ora ora = new Ora(dataRaw.get(0), Integer.parseInt(hoursSplit[0]), Integer.parseInt(hoursSplit[1]),
                        dataRaw.get(3), dataRaw.get(4), dataRaw.get(5), dataRaw.get(6));
                mondayData.add(ora);
            }
        }
        Log.d("COUNT", String.valueOf(mondayData.size()));
    }

    public List<Ora> getMondayData() {
        return mondayData;
    }
}
