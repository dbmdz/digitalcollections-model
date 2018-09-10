package de.digitalcollections.model.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.ContentTree;
import de.digitalcollections.model.api.identifiable.entity.Website;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.Translation;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Blockquote;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.BulletList;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.CodeBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.ListItem;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.OrderedList;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.api.identifiable.entity.parts.ContentNode;
import de.digitalcollections.model.api.identifiable.resource.IiifImage;
import de.digitalcollections.model.api.identifiable.resource.Resource;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.security.User;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.ArticleMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.ContentTreeMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.WebsiteMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.LocalizedTextMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.TranslationMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.ContentBlockMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.LocalizedStructuredContentMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.StructuredContentMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.BlockquoteMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.BulletListMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.CodeBlockMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.HeadingMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.IFrameMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.ListItemMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.MarkMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.OrderedListMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.ParagraphMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TextMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.parts.ContentNodeMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.IiifImageMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.ResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.parts.WebpageMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.FileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.paging.OrderMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageRequestMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageResponseMixIn;
import de.digitalcollections.model.jackson.mixin.paging.SortingMixIn;
import de.digitalcollections.model.jackson.mixin.security.UserMixIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitalCollectionsModelModule extends Module {

  private static final Logger LOGGER = LoggerFactory.getLogger(DigitalCollectionsModelModule.class);

  @Override
  public String getModuleName() {
    return "DigitalCollections Model jackson module";
  }

  @Override
  public void setupModule(SetupContext context) {
    LOGGER.info("Using DigitalCollectionsModelModule");

    context.setMixInAnnotations(Article.class, ArticleMixIn.class);
    context.setMixInAnnotations(Blockquote.class, BlockquoteMixIn.class);
    context.setMixInAnnotations(BulletList.class, BulletListMixIn.class);
    context.setMixInAnnotations(CodeBlock.class, CodeBlockMixIn.class);
    context.setMixInAnnotations(ContentBlock.class, ContentBlockMixIn.class);
    context.setMixInAnnotations(ContentNode.class, ContentNodeMixIn.class);
    context.setMixInAnnotations(ContentTree.class, ContentTreeMixIn.class);
    //    context.setMixInAnnotations(Entity.class, EntityMixIn.class); // FIXME not needed/working, switched back to wrapper info...
    context.setMixInAnnotations(FileResource.class, FileResourceMixIn.class);
    context.setMixInAnnotations(Heading.class, HeadingMixIn.class);
    context.setMixInAnnotations(IFrame.class, IFrameMixIn.class);
    context.setMixInAnnotations(IiifImage.class, IiifImageMixIn.class);
    context.setMixInAnnotations(ListItem.class, ListItemMixIn.class);
    context.setMixInAnnotations(LocalizedStructuredContent.class, LocalizedStructuredContentMixIn.class);
    context.setMixInAnnotations(LocalizedText.class, LocalizedTextMixIn.class);
    context.setMixInAnnotations(Mark.class, MarkMixIn.class);
    context.setMixInAnnotations(Order.class, OrderMixIn.class);
    context.setMixInAnnotations(OrderedList.class, OrderedListMixIn.class);
    context.setMixInAnnotations(PageRequest.class, PageRequestMixIn.class);
    context.setMixInAnnotations(PageResponse.class, PageResponseMixIn.class);
    context.setMixInAnnotations(Paragraph.class, ParagraphMixIn.class);
    context.setMixInAnnotations(Resource.class, ResourceMixIn.class);
    context.setMixInAnnotations(Sorting.class, SortingMixIn.class);
    context.setMixInAnnotations(StructuredContent.class, StructuredContentMixIn.class);
    context.setMixInAnnotations(Text.class, TextMixIn.class);
    context.setMixInAnnotations(Translation.class, TranslationMixIn.class);
    context.setMixInAnnotations(User.class, UserMixIn.class);
    context.setMixInAnnotations(Webpage.class, WebpageMixIn.class);
    context.setMixInAnnotations(Website.class, WebsiteMixIn.class);
  }

  @Override
  public Version version() {
    return new Version(1, 0, 0, "SNAPSHOT", "de.digitalcollections.model", "dc-model-jackson");
  }

}
