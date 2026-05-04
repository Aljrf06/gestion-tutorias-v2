import { useState } from "react";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import Dashboard from "./pages/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [vista, setVista] = useState("login");

  if (!token) {
    return vista === "login"
      ? <LoginPage setToken={setToken} goToRegister={() => setVista("register")} />
      : <RegisterPage goToLogin={() => setVista("login")} />;
  }

 return <Dashboard setToken={setToken} />;
}

export default App;