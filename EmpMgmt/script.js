document.getElementById('employeeForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    const employeeId = document.getElementById('employeeId').value;
    const employeeName = document.getElementById('employeeName').value;
    const dateOfJoining = document.getElementById('dateOfJoining').value;
    const mobile = document.getElementById('mobile').value;
    const email = document.getElementById('email').value;
    const salary = document.getElementById('salary').value;
    const designation = document.getElementById('designation').value;
    const alternativeMobile = document.getElementById('alternativeMobile').value;

    fetch('http://127.0.0.1:5500/api/employees/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            employeeId,
            employeeName,
            dateOfJoining,
            mobile,
            email,
            salary,
            designation,
            alternativeMobile
        }),
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Something went wrong');
        }
    })
    .then(data => {
        console.log(data);
        alert('Form submitted successfully!');
    })
    .catch(error => {
        console.error('Error:', error);
    });
});