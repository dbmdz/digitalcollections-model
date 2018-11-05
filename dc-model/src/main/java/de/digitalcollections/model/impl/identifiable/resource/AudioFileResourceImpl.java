package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.AudioFileResource;

public class AudioFileResourceImpl extends FileResourceImpl implements AudioFileResource {

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
