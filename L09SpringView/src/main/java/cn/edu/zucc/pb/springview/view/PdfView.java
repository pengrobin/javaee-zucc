package cn.edu.zucc.pb.springview.view;

import cn.edu.zucc.pb.springview.entity.QuestionEntity;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-22 17:18
 */
public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        QuestionEntity entity = (QuestionEntity)model.get("question");
        document.add(new Paragraph(entity.getTitle()));
        document.add(new Paragraph(entity.getCreateDate().toString()));
    }
}
