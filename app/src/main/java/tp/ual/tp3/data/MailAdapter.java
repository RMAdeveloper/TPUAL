package tp.ual.tp3.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tp.ual.tp3.R;


public class MailAdapter extends ArrayAdapter<Mail> {
    private List<Mail> mailList;

    public MailAdapter(Context context, List<Mail> mailList) {
        super(context, 0, mailList);
        this.mailList = mailList;
    }

    @Override
    public View getView(int position, View recycledView, ViewGroup parent) {
        Mail currentMail = mailList.get(position);

        if(recycledView == null) {
            recycledView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_mail, parent, false);
        }

        TextView subject = (TextView) recycledView.findViewById(R.id.maillistsubject);
        TextView from = (TextView) recycledView.findViewById(R.id.maillistfrom);

        subject.setText(currentMail.getSubject());
        from.setText(currentMail.getFrom());

        return recycledView;
    }
}
