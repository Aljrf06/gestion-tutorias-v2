import { useEffect, useState } from "react";
import { listar, eliminar, actualizar } from "../api/usuarioApi";
import "../App.css";

export default function Dashboard({ setToken }) {

  const [usuarios, setUsuarios] = useState([]);
  const [editandoId, setEditandoId] = useState(null);
  const [formEdit, setFormEdit] = useState({});

  const cargar = async () => {
    const res = await listar();
    setUsuarios(res.data);
  };

  useEffect(() => { cargar(); }, []);

  const handleDelete = async (id) => {
    await eliminar(id);
    cargar();
  };

  // 👉 iniciar edición
  const iniciarEdicion = (usuario) => {
    setEditandoId(usuario.id);
    setFormEdit(usuario);
  };

  // 👉 guardar cambios
  const guardar = async () => {
    await actualizar(editandoId, formEdit);
    setEditandoId(null);
    cargar();
  };

  return (
    <div className="container mt-5">

      {/* 🔓 LOGOUT */}
      <button
        className="btn btn-dark mb-3"
        onClick={() => {
          localStorage.removeItem("token");
          setToken(null);
        }}
      >
        Cerrar sesión
      </button>

      <div className="table-container">
        <h3 className="mb-3">Usuarios</h3>

        <table className="table table-hover">
          <thead className="table-dark">
            <tr>
              <th>Nombre</th>
              <th>Email</th>
              <th>Tipo</th>
              <th>Acciones</th>
            </tr>
          </thead>

          <tbody>
            {usuarios.map(u => (
              <tr key={u.id}>

                {/* NOMBRE */}
                <td>
                  {editandoId === u.id ? (
                    <input
                      className="form-control"
                      value={formEdit.nombre}
                      onChange={e =>
                        setFormEdit({ ...formEdit, nombre: e.target.value })
                      }
                    />
                  ) : (
                    `${u.nombre} ${u.apellido}`
                  )}
                </td>

                {/* EMAIL */}
                <td>
                  {editandoId === u.id ? (
                    <input
                      className="form-control"
                      value={formEdit.email}
                      onChange={e =>
                        setFormEdit({ ...formEdit, email: e.target.value })
                      }
                    />
                  ) : (
                    u.email
                  )}
                </td>

                {/* TIPO */}
                <td>
                  {editandoId === u.id ? (
                    <select
                      className="form-control"
                      value={formEdit.tipo}
                      onChange={e =>
                        setFormEdit({ ...formEdit, tipo: e.target.value })
                      }
                    >
                      <option value="estudiante">Estudiante</option>
                      <option value="tutor">Tutor</option>
                    </select>
                  ) : (
                    u.tipo
                  )}
                </td>

                {/* ACCIONES */}
                <td>
                  {editandoId === u.id ? (
                    <>
                      <button
                        className="btn btn-success btn-sm me-2"
                        onClick={guardar}
                      >
                        Guardar
                      </button>

                      <button
                        className="btn btn-secondary btn-sm"
                        onClick={() => setEditandoId(null)}
                      >
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button
                        className="btn btn-warning btn-sm me-2"
                        onClick={() => iniciarEdicion(u)}
                      >
                        Editar
                      </button>

                      <button
                        className="btn btn-danger btn-sm"
                        onClick={() => handleDelete(u.id)}
                      >
                        Eliminar
                      </button>
                    </>
                  )}
                </td>

              </tr>
            ))}
          </tbody>

        </table>
      </div>
    </div>
  );
}