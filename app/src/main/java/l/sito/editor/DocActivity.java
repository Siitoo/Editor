package l.sito.editor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;
    private String title = "title", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut dolor at ante porta dignissim. Sed sit amet bibendum diam. Mauris facilisis massa sit amet libero ultrices ullamcorper. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean varius semper nisi sit amet commodo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent leo lectus, ullamcorper at elit nec, ultricies suscipit massa. Quisque sit amet rhoncus felis.";
    private TextView title_view;
    private TextView doc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        title_view = findViewById(R.id.TitleView);
        doc_view = findViewById(R.id.textView);

        title_view.setText(title);
        doc_view.setText(doc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.option_edit_title:
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text",title);
                startActivityForResult(intent, EDIT_TITLE);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case EDIT_TITLE:
                if(resultCode == RESULT_OK)
                {
                    title = data.getStringExtra("text");
                    title_view.setText(title);
                }
                break;

            default:
                super.onActivityResult(requestCode,resultCode,data);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
