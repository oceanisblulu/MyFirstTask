package com.example.a421zhengying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Message> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();//初始化消息数据

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Message msg = new Message(content, Message.TYPE_SENT);
                    msgList.add(msg);
                    //当有新消息时，刷新RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //将RecyclerView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //清空输入框中的内容
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
        Message msg1 = new Message("你好啊！", Message.TYPE_RECEIVED);
        msgList.add(msg1);
        Message msg2 = new Message("你谁呀。", Message.TYPE_SENT);
        msgList.add(msg2);
        Message msg3 = new Message("我，喜羊羊", Message.TYPE_RECEIVED);
        msgList.add(msg3);
        Message msg4 = new Message("你找错人了，我是光头强", Message.TYPE_SENT);
        msgList.add(msg4);
    }
}
