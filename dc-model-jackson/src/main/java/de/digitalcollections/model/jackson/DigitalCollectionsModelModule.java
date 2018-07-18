package de.digitalcollections.model.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import de.digitalcollections.model.jackson.mixin.paging.OrderMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageRequestMixIn;
import de.digitalcollections.model.jackson.mixin.paging.PageResponseMixIn;
import de.digitalcollections.model.jackson.mixin.paging.SortingMixIn;
import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
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
    context.setMixInAnnotations(Order.class, OrderMixIn.class);
    context.setMixInAnnotations(PageRequest.class, PageRequestMixIn.class);
    context.setMixInAnnotations(PageResponse.class, PageResponseMixIn.class);
    context.setMixInAnnotations(Sorting.class, SortingMixIn.class);
  }

  @Override
  public Version version() {
    return new Version(1, 0, 0, "SNAPSHOT", "de.digitalcollections.model", "dc-model-jackson");
  }

}
