package kz.abcsoft.android.demo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class MainActivity extends ActionBarActivity {

    private Fragment1 fragment1 ;
    private Fragment2 fragment2 ;
    private FragmentTransaction fTrans ;
    private CheckBox chbStack ;


    public void onClick(View v){
        fTrans = getFragmentManager().beginTransaction() ;
        switch(v.getId()){
            case R.id.btnAdd:
                fTrans.add(R.id.frgmCont, fragment1) ;
                break ;
            case R.id.btnRemove:
                fTrans.remove(fragment1);
                break ;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, fragment2) ;
                break ;

        }
        if(chbStack.isChecked())
            fTrans.addToBackStack(null) ;

        fTrans.commit() ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1() ;
        fragment2 = new Fragment2() ;

        chbStack = (CheckBox)findViewById(R.id.chbStack) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
