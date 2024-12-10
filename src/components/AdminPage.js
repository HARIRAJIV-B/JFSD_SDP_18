import React, { useState, useEffect } from 'react';
import './AdminPage.css';

const AdminPage = () => {
  const [users, setUsers] = useState([]);
  const [showUsers, setShowUsers] = useState(false);

  useEffect(() => {
    const authToken = localStorage.getItem('authToken');
    if (!authToken || authToken !== 'admin') {
      window.location.href = '/login';
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('authToken');
    window.location.href = '/login';
  };

  const fetchUsers = async () => {
    try {
      const response = await fetch('http://localhost:8081/user/retrieve'); // Endpoint for all users
      const data = await response.json();
      console.log('Users:', data);

      const professionals = data.filter(user => user.role === 'professional');
      const clients = data.filter(user => user.role === 'client');

      setUsers([...professionals, ...clients]); 
      setShowUsers(true);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  return (
    <div className="admin-page">
      <header className="admin-header">
        <h1>Admin Dashboard</h1>
        <button className="logout-button" onClick={handleLogout}>
          Logout
        </button>
      </header>
      <section className="admin-content">
        <p>Manage platform settings, user roles, and service listings.</p>
        <div className="admin-buttons">
          <button className="admin-btn" onClick={fetchUsers}>
            Manage Users
          </button>
          <button className="admin-btn">Review Service Listings</button>
          <button className="admin-btn">Platform Settings</button>
        </div>

        {showUsers && (
  <div className="user-list">
    <h2>Users</h2>
    <table className="user-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Username</th>
          <th>Role</th>
        </tr>
      </thead>
      <tbody>
        {users.map(user => (
          <tr key={user.id}>
            <td>{user.id}</td>
            <td>{user.username}</td>
            <td>{user.role}</td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
)}

      </section>
    </div>
  );
};

export default AdminPage;
