package ca.qc.cstjean.francais.stages.francaisgo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.UUID;

/**
 * Created by Antoine on 2016-12-07.
 */

public class Inscription {

    protected Fragment createFragment()
    {
        return new InscriptionFragment();
    }
}
