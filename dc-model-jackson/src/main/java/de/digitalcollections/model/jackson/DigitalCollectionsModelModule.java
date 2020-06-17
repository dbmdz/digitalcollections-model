package de.digitalcollections.model.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;
import de.digitalcollections.model.api.filter.FilterCriterion;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.IdentifierType;
import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.Collection;
import de.digitalcollections.model.api.identifiable.entity.Corporation;
import de.digitalcollections.model.api.identifiable.entity.DigitalObject;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.EntityRelation;
import de.digitalcollections.model.api.identifiable.entity.Project;
import de.digitalcollections.model.api.identifiable.entity.Topic;
import de.digitalcollections.model.api.identifiable.entity.Website;
import de.digitalcollections.model.api.identifiable.entity.parts.Subtopic;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.RenderingHintsPreviewImage;
import de.digitalcollections.model.api.identifiable.parts.Translation;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Blockquote;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.BulletList;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.CodeBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Image;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.ListItem;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.OrderedList;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Table;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.TableCell;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.TableHeader;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.TableRow;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.api.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.api.identifiable.resource.AudioFileResource;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.api.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.api.identifiable.resource.MimeType;
import de.digitalcollections.model.api.identifiable.resource.TextFileResource;
import de.digitalcollections.model.api.identifiable.resource.VideoFileResource;
import de.digitalcollections.model.api.legal.License;
import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.SearchPageRequest;
import de.digitalcollections.model.api.paging.SearchPageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.security.User;
import de.digitalcollections.model.api.view.BreadcrumbNavigation;
import de.digitalcollections.model.jackson.mixin.filter.FilterCriterionMixIn;
import de.digitalcollections.model.jackson.mixin.filter.FilteringMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifierMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifierTypeMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.NodeMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.VersionMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.ArticleMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.CollectionMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.CorporationMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.DigitalObjectMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityRelationMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.ProjectMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.TopicMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.WebsiteMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.parts.SubtopicMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.parts.WebpageMixIn;
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
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.ImageMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.ListItemMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.MarkMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.OrderedListMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.ParagraphMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TableCellMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TableHeaderMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TableMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TableRowMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks.TextMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.ApplicationFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.AudioFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.FileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.ImageFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.LinkedDataFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.RenderingHintsPreviewImageMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.TextFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.identifiable.resource.VideoFileResourceMixIn;
import de.digitalcollections.model.jackson.mixin.legal.LicenseMixIn;
import de.digitalcollections.model.jackson.mixin.paging.OrderMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageRequestMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageResponseMixIn;
import de.digitalcollections.model.jackson.mixin.paging.SearchPageRequestMixIn;
import de.digitalcollections.model.jackson.mixin.paging.SearchPageResponseMixIn;
import de.digitalcollections.model.jackson.mixin.paging.SortingMixIn;
import de.digitalcollections.model.jackson.mixin.security.UserMixIn;
import de.digitalcollections.model.jackson.mixin.view.BreadcrumbNavigationMixIn;
import java.util.ResourceBundle;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitalCollectionsModelModule extends SimpleModule {

  private static final Logger LOGGER = LoggerFactory.getLogger(DigitalCollectionsModelModule.class);
  protected static ResourceBundle rb = ResourceBundle.getBundle("dc-model-jackson-version");

  public DigitalCollectionsModelModule() {
    super();

    // Just use MimeType's getTypeName and String constructor for serializing/deserializing it
    addSerializer(new StdDelegatingSerializer(MimeType.class, toString(MimeType::getTypeName)));
    addDeserializer(
        MimeType.class, new StdDelegatingDeserializer<>(fromString(MimeType::fromTypename)));
  }

  @Override
  public String getModuleName() {
    return "DigitalCollections Model jackson module";
  }

  @Override
  public Version version() {
    return VersionUtil.parseVersion(
        rb.getString("project.version"),
        rb.getString("project.groupId"),
        rb.getString("project.artifactId"));
  }

  @Override
  public void setupModule(SetupContext context) {
    super.setupModule(context);

    LOGGER.info("Using DigitalCollectionsModelModule " + version().toFullString());

    context.setMixInAnnotations(ApplicationFileResource.class, ApplicationFileResourceMixIn.class);
    context.setMixInAnnotations(Article.class, ArticleMixIn.class);
    context.setMixInAnnotations(AudioFileResource.class, AudioFileResourceMixIn.class);
    context.setMixInAnnotations(Blockquote.class, BlockquoteMixIn.class);
    context.setMixInAnnotations(BreadcrumbNavigation.class, BreadcrumbNavigationMixIn.class);
    context.setMixInAnnotations(BulletList.class, BulletListMixIn.class);
    context.setMixInAnnotations(CodeBlock.class, CodeBlockMixIn.class);
    context.setMixInAnnotations(Collection.class, CollectionMixIn.class);
    context.setMixInAnnotations(ContentBlock.class, ContentBlockMixIn.class);
    context.setMixInAnnotations(Corporation.class, CorporationMixIn.class);
    context.setMixInAnnotations(DigitalObject.class, DigitalObjectMixIn.class);
    context.setMixInAnnotations(Entity.class, EntityMixIn.class);
    context.setMixInAnnotations(EntityRelation.class, EntityRelationMixIn.class);
    context.setMixInAnnotations(FileResource.class, FileResourceMixIn.class);
    context.setMixInAnnotations(FilterCriterion.class, FilterCriterionMixIn.class);
    context.setMixInAnnotations(Filtering.class, FilteringMixIn.class);
    context.setMixInAnnotations(Heading.class, HeadingMixIn.class);
    context.setMixInAnnotations(Identifier.class, IdentifierMixIn.class);
    context.setMixInAnnotations(IdentifierType.class, IdentifierTypeMixIn.class);
    context.setMixInAnnotations(IFrame.class, IFrameMixIn.class);
    context.setMixInAnnotations(Image.class, ImageMixIn.class);
    context.setMixInAnnotations(ImageFileResource.class, ImageFileResourceMixIn.class);
    context.setMixInAnnotations(License.class, LicenseMixIn.class);
    context.setMixInAnnotations(LinkedDataFileResource.class, LinkedDataFileResourceMixIn.class);
    context.setMixInAnnotations(ListItem.class, ListItemMixIn.class);
    context.setMixInAnnotations(
        LocalizedStructuredContent.class, LocalizedStructuredContentMixIn.class);
    context.setMixInAnnotations(LocalizedText.class, LocalizedTextMixIn.class);
    context.setMixInAnnotations(Mark.class, MarkMixIn.class);
    context.setMixInAnnotations(Node.class, NodeMixIn.class);
    context.setMixInAnnotations(Order.class, OrderMixIn.class);
    context.setMixInAnnotations(OrderedList.class, OrderedListMixIn.class);
    context.setMixInAnnotations(PageRequest.class, PageRequestMixIn.class);
    context.setMixInAnnotations(PageResponse.class, PageResponseMixIn.class);
    context.setMixInAnnotations(Paragraph.class, ParagraphMixIn.class);
    context.setMixInAnnotations(Project.class, ProjectMixIn.class);
    context.setMixInAnnotations(
        RenderingHintsPreviewImage.class, RenderingHintsPreviewImageMixIn.class);
    context.setMixInAnnotations(SearchPageRequest.class, SearchPageRequestMixIn.class);
    context.setMixInAnnotations(SearchPageResponse.class, SearchPageResponseMixIn.class);
    context.setMixInAnnotations(Sorting.class, SortingMixIn.class);
    context.setMixInAnnotations(StructuredContent.class, StructuredContentMixIn.class);
    context.setMixInAnnotations(Subtopic.class, SubtopicMixIn.class);
    context.setMixInAnnotations(Table.class, TableMixIn.class);
    context.setMixInAnnotations(TableCell.class, TableCellMixIn.class);
    context.setMixInAnnotations(TableHeader.class, TableHeaderMixIn.class);
    context.setMixInAnnotations(TableRow.class, TableRowMixIn.class);
    context.setMixInAnnotations(Text.class, TextMixIn.class);
    context.setMixInAnnotations(TextFileResource.class, TextFileResourceMixIn.class);
    context.setMixInAnnotations(Topic.class, TopicMixIn.class);
    context.setMixInAnnotations(Translation.class, TranslationMixIn.class);
    context.setMixInAnnotations(User.class, UserMixIn.class);
    context.setMixInAnnotations(
        de.digitalcollections.model.api.identifiable.Version.class, VersionMixIn.class);
    context.setMixInAnnotations(VideoFileResource.class, VideoFileResourceMixIn.class);
    context.setMixInAnnotations(Webpage.class, WebpageMixIn.class);
    context.setMixInAnnotations(Website.class, WebsiteMixIn.class);
  }

  /** Helper function to create Converter from lambda * */
  private <T> Converter<String, T> fromString(Function<String, ? extends T> fun) {
    return new StdConverter<String, T>() {
      @Override
      public T convert(String value) {
        return fun.apply(value);
      }
    };
  }

  /** Helper function to create Converter from lambda * */
  private <T> Converter<T, String> toString(Function<T, String> fun) {
    return new StdConverter<T, String>() {
      @Override
      public String convert(T value) {
        return fun.apply(value);
      }
    };
  }
}
