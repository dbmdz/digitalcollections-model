package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.VideoFileResource;

public class VideoFileResourceImpl extends FileResourceImpl implements VideoFileResource {

  private int duration;

  @Override
  public int getDuration() {
    return duration;
  }

  @Override
  public void setDuration(int duration) {
    this.duration = duration;
  }
}
