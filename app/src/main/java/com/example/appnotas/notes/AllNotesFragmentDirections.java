package com.example.appnotas.notes;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;

import com.example.appnotas.R;
import com.example.appnotas.database.Notes;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Clase de navegación generada para `AllNotesFragment` con dirección a `EditNoteFragment`.
 *
 * Se utiliza en el sistema de navegación de Jetpack para manejar el paso de datos entre fragmentos.
 */
public class AllNotesFragmentDirections {
  private AllNotesFragmentDirections() {
  }

    /**
     * Crea la acción de navegación desde `AllNotesFragment` hacia `EditNoteFragment`.
     *
     * @return Acción de navegación con la posibilidad de pasar argumentos.
     */
      @NonNull
      public static ActionAllNotesFragmentToEditNoteFragment actionAllNotesFragmentToEditNoteFragment(
          ) {
        return new ActionAllNotesFragmentToEditNoteFragment();
      }

    /**
     * Clase interna que representa la acción de navegar hacia `EditNoteFragment`,
     * permitiendo enviar una nota para ser editada.
     */
      public static class ActionAllNotesFragmentToEditNoteFragment implements NavDirections {
        private final HashMap arguments = new HashMap();

        private ActionAllNotesFragmentToEditNoteFragment() {
        }

        /**
         * Establece la nota a actualizar en la navegación.
         *
         * @param updateNote Nota a pasar al fragmento de edición.
         * @return Instancia de la acción con el argumento configurado.
         */
        @NonNull
        @SuppressWarnings("unchecked")
        public ActionAllNotesFragmentToEditNoteFragment setUpdateNote(@Nullable Notes updateNote) {
          this.arguments.put("updateNote", updateNote);
          return this;
        }

        /**
         * Obtiene los argumentos configurados para la navegación.
         *
         * @return Un `Bundle` con los parámetros establecidos.
         */
        @Override
        @SuppressWarnings("unchecked")
        @NonNull
        public Bundle getArguments() {
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

        /**
         * Obtiene el ID de la acción de navegación.
         *
         * @return ID de la acción que lleva a `EditNoteFragment`.
         */
        @Override
        public int getActionId() {
          return R.id.action_allNotesFragment_to_editNoteFragment;
        }

        /**
         * Recupera la nota establecida para la actualización.
         *
         * @return La nota a actualizar, o `null` si no se ha configurado.
         */
        @SuppressWarnings("unchecked")
        @Nullable
        public Notes getUpdateNote() {
          return (Notes) arguments.get("updateNote");
        }

        // Métodos de comparación y representación de la acción
        @Override
        public boolean equals(Object object) {
          if (this == object) {
              return true;
          }
          if (object == null || getClass() != object.getClass()) {
              return false;
          }
          ActionAllNotesFragmentToEditNoteFragment that = (ActionAllNotesFragmentToEditNoteFragment) object;
          if (arguments.containsKey("updateNote") != that.arguments.containsKey("updateNote")) {
            return false;
          }
          if (getUpdateNote() != null ? !getUpdateNote().equals(that.getUpdateNote()) : that.getUpdateNote() != null) {
            return false;
          }
          if (getActionId() != that.getActionId()) {
            return false;
          }
          return true;
        }

        @Override
        public int hashCode() {
          int result = 1;
          result = 31 * result + (getUpdateNote() != null ? getUpdateNote().hashCode() : 0);
          result = 31 * result + getActionId();
          return result;
        }

        @Override
        public String toString() {
          return "ActionAllNotesFragmentToEditNoteFragment(actionId=" + getActionId() + "){"
              + "updateNote=" + getUpdateNote()
              + "}";
        }
      }
}
