package org.zwhy.swag.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * @author ZWHySwag
 * @date 2021\8\9 0009 22:02
 */
public class MarkDownUtils {

    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().softbreak("<br/>").build();
        return renderer.render(document);
    }

    public static String markdownToHtmlExtensions(String markdown) {
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        List<Extension> tableExtentions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(tableExtentions).build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(headingAnchorExtensions)
                .extensions(tableExtentions)
                .attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new CustomAttributeProvider();
                    }
                }).softbreak("<br/>").build();
        return renderer.render(document);
    }

    static  class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String s, Map<String, String> map) {
            if (node instanceof Link) {
                map.put("target", "_blank");
            }
            if (node instanceof TableBlock) {
                map.put("class", "ui celled table");
            }
        }
    }

    public static void main(String[] args) {
        String content = markdownToHtmlExtensions("很久很久以前，所有的感觉和情感都去一个海滨小岛度假，每个人都玩得很开心。突然，暴风雨即将来临的警报被宣布，所有人都被建议撤离这个岛。\n" +
                "    通告引起了突然的恐慌。所有人都冲向他们的船。甚至损坏的船也很快被修好并委托执行任务。\n" +
                "    然而，爱情并不希望匆匆离去。还有很多事要做。但当乌云变暗，爱意识到是时候离开了。唉，没有多余的船了。爱带着希望环顾四周。\n" +
                "    就在这时，繁荣乘着一艘豪华的小船经过，爱在大声呼喊，繁荣，你能带我上你的小船吗？\n" +
                "    “不，”富贵回答，“我的船上装满了珍贵的财产，金银，没有你的容身之地。\n" +
                "    过了一会儿，一艘漂亮的小船经过。爱情再次呼喊，你能帮助我吗，虚荣？我被困住了，需要搭个便车。请带我一起走。\n" +
                "    虚荣傲慢地回答，不，我不能带你走，我的船会被你的泥脚弄脏的。\n" +
                "    悲伤过了一段时间就过去了。再说一次，爱情需要帮助。但是没有用。不，我不能带你走。我好难过。我想一个人呆着。\n" +
                "    几分钟后，当幸福经过时，爱又开始呼救了。但是幸福是如此的快乐，以至于它不会环顾四周，几乎不关心任何人。\n" +
                "    爱情变得焦躁不安和沮丧。就在这时，有人喊道，来吧，亲爱的，我会带你一起走。爱不知道是谁这么宽宏大量，跳上了船，因为她会到达一个安全的地方而松了一口气。\n" +
                "    下船后，爱情遇到了知识。困惑，爱情询问，知识，你知道是谁在没人愿意帮忙的时候，如此慷慨地搭了我的车吗？\n" +
                "    知识在微笑，哦，那是时间。\n" +
                "    为什么时间会停下来把我带到安全的地方? 爱在想。\n" +
                "    知识带着深邃的智慧微笑着回答，因为只有时间知道你真正的伟大和你的能力。只有爱才能给这个世界带来和平和幸福\n" +
                "    重要的信息是，当我们富裕的时候，我们忽视了爱情。当我们觉得自己很重要的时候，我们就会忘记爱。即使在快乐和悲伤中，我们也会忘记爱情。只有随着时间的流逝，我们才会意识到爱的重要性。为什么要等那么久？为什么不让爱成为你今天生活的一部分呢？");
        System.out.println(content);
    }
}
