export default function UsuarioForm({ usuario, onSave }) {
  const handleChange = (e) => {
    onSave({ ...usuario, [e.target.name]: e.target.value });
  };

  return (
    <>
      <input name="nombre" value={usuario.nombre}
        onChange={handleChange} className="form-control mb-1" />

      <input name="apellido" value={usuario.apellido}
        onChange={handleChange} className="form-control mb-1" />

      <input name="email" value={usuario.email}
        onChange={handleChange} className="form-control mb-1" />
    </>
  );
}