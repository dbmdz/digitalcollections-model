package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.VideoFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;

public class VideoFileResourceImpl extends FileResourceImpl implements VideoFileResource {

  private int duration;

  public VideoFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.VIDEO;
  }

  @Override
  public int getDuration() {
    return duration;
  }

  @Override
  public void setDuration(int duration) {
    this.duration = duration;
  }
}
