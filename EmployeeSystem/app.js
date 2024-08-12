// app.js
async function fetchEmployees() {
    try {
        const response = await fetch('http://localhost:8080/api/employees');
        const employees = await response.json();

        const employeeListDiv = document.getElementById('employee-list');
        employees.forEach(employee => {
            const employeeDiv = document.createElement('div');
            employeeDiv.textContent = `Name: ${employee.employeeName}, Email: ${employee.email}`;
            employeeListDiv.appendChild(employeeDiv);
        });
    } catch (error) {
        console.error('Error fetching employees:', error);
    }
}

fetchEmployees();
