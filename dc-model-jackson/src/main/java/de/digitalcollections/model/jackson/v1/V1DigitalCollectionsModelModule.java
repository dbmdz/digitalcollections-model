package de.digitalcollections.model.jackson.v1;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.Module.SetupContext;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.jackson.DigitalCollectionsModelModule;
import de.digitalcollections.model.jackson.v1.mixin.identifiable.parts.structuredcontent.V1LocalizedStructuredContentMixIn;

public class V1DigitalCollectionsModelModule extends DigitalCollectionsModelModule {

  public V1DigitalCollectionsModelModule() {
    super();
  }

  @Override
  public String getModuleName() {
    return "V1 DigitalCollections Model jackson module";
  }

  @Override
  public Version version() {
    return VersionUtil.parseVersion(
            "V1",
            rb.getString("project.groupId"),
            rb.getString("project.artifactId"));
  }

  @Override
  public void setupModule(SetupContext context) {
    super.setupModule(context);

    context.setMixInAnnotations(LocalizedStructuredContent.class, V1LocalizedStructuredContentMixIn.class);
  }
}
