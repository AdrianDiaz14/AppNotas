package com.example.appnotas.notes;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;

import com.example.appnotas.database.Notes;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Argumentos de navegación para `EditNoteFragment`, permitiendo pasar una nota para edición.
 * Se usa en el sistema de navegación de Jetpack (`NavArgs`).
 */
public class EditNoteFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private EditNoteFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private EditNoteFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  /**
   * Crea una instancia de `EditNoteFragmentArgs` a partir de un `Bundle`.
   * @param bundle Contenedor con los argumentos de navegación.
   * @return Instancia de `EditNoteFragmentArgs`.
   */
  @NonNull
  @SuppressWarnings({
      "unchecked",
      "deprecation"
  })
  public static EditNoteFragmentArgs fromBundle(@NonNull Bundle bundle) {
    EditNoteFragmentArgs __result = new EditNoteFragmentArgs();
    bundle.setClassLoader(EditNoteFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("updateNote")) {
      Notes updateNote;
      if (Parcelable.class.isAssignableFrom(Notes.class) || Serializable.class.isAssignableFrom(Notes.class)) {
        updateNote = (Notes) bundle.get("updateNote");
      } else {
        throw new UnsupportedOperationException(Notes.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("updateNote", updateNote);
    } else {
      __result.arguments.put("updateNote", null);
    }
    return __result;
  }

  /**
   * Crea una instancia de `EditNoteFragmentArgs` a partir de `SavedStateHandle`.
   * @param savedStateHandle Estado guardado de la navegación.
   * @return Instancia de `EditNoteFragmentArgs`.
   */
  @NonNull
  @SuppressWarnings("unchecked")
  public static EditNoteFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    EditNoteFragmentArgs __result = new EditNoteFragmentArgs();
    if (savedStateHandle.contains("updateNote")) {
      Notes updateNote;
      updateNote = savedStateHandle.get("updateNote");
      __result.arguments.put("updateNote", updateNote);
    } else {
      __result.arguments.put("updateNote", null);
    }
    return __result;
  }

  /**
   * Obtiene la nota pasada como argumento.
   * @return Nota a actualizar, o `null` si no se proporcionó.
   */
  @SuppressWarnings("unchecked")
  @Nullable
  public Notes getUpdateNote() {
    return (Notes) arguments.get("updateNote");
  }

  /**
   * Convierte los argumentos a `Bundle`.
   * @return `Bundle` con los argumentos de la navegación.
   */
  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("updateNote")) {
      Notes updateNote = (Notes) arguments.get("updateNote");
      if (Parcelable.class.isAssignableFrom(Notes.class) || updateNote == null) {
        __result.putParcelable("updateNote", Parcelable.class.cast(updateNote));
      } else if (Serializable.class.isAssignableFrom(Notes.class)) {
        __result.putSerializable("updateNote", Serializable.class.cast(updateNote));
      } else {
        throw new UnsupportedOperationException(Notes.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    } else {
      __result.putSerializable("updateNote", null);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("updateNote")) {
      Notes updateNote = (Notes) arguments.get("updateNote");
      if (Parcelable.class.isAssignableFrom(Notes.class) || updateNote == null) {
        __result.set("updateNote", Parcelable.class.cast(updateNote));
      } else if (Serializable.class.isAssignableFrom(Notes.class)) {
        __result.set("updateNote", Serializable.class.cast(updateNote));
      } else {
        throw new UnsupportedOperationException(Notes.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    } else {
      __result.set("updateNote", null);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    EditNoteFragmentArgs that = (EditNoteFragmentArgs) object;
    if (arguments.containsKey("updateNote") != that.arguments.containsKey("updateNote")) {
      return false;
    }
    if (getUpdateNote() != null ? !getUpdateNote().equals(that.getUpdateNote()) : that.getUpdateNote() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUpdateNote() != null ? getUpdateNote().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "EditNoteFragmentArgs{"
        + "updateNote=" + getUpdateNote()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull EditNoteFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public EditNoteFragmentArgs build() {
      EditNoteFragmentArgs result = new EditNoteFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUpdateNote(@Nullable Notes updateNote) {
      this.arguments.put("updateNote", updateNote);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public Notes getUpdateNote() {
      return (Notes) arguments.get("updateNote");
    }
  }
}
