from flask import Flask, request, jsonify, Response
import json
import psycopg2

app = Flask(__name__)

#Conexion a PostgresSQL
try:
    conn = psycopg2.connect(dbname="Company",
        user="postgres",
        password="211215",
        host="localhost",
        port="5432")
except psycopg2.Error as e:
    print('Ocurrio un error al conectar')

#Configuracion
app.secret_key = 'mysecretkey'

#Metodo para obtener todos los datos
@app.route('/employees', methods=['GET'])
def getEmployees():
    cur = conn.cursor()
    cur.execute('SELECT * FROM employees')
    data = cur.fetchall()
    return jsonify(data)

#Metodo para obtener un dato
@app.route('/employees/<id>', methods=['GET'])
def getEmployee(id):
    cur = conn.cursor()
    cur.execute('SELECT * FROM employees WHERE id = %s', id)
    data = cur.fetchone()
    return jsonify(data)

@app.route('/employees', methods=['POST'])
def createEmployee():
    name = request.json['name']
    address = request.json['address']
    phone = request.json['phone']
    cur = conn.cursor()
    cur.execute('INSERT INTO employees (name, address, phone) VALUES (%s, %s, %s)', (name, address, phone))
    conn.commit()  
    return({"message": "Empleado agregado con exito"})

@app.route('/employees/<id>', methods=['PUT'])
def updateEmployee(id):
    name = request.json['name']
    address = request.json['address']
    phone = request.json['phone']
    cur = conn.cursor()
    cur.execute('UPDATE employees SET name = %s, address = %s, phone = %s WHERE id = %s',
                (name, address, phone, id))
    conn.commit()
    return({"message": "Empleado actualizado con exito"})

@app.route('/employees/<id>', methods=['DELETE'])
def deleteEmployee(id):
    cur = conn.cursor()
    cur.execute('DELETE FROM employees WHERE id = {0}'.format(id))
    conn.commit()
    return({"message": "Empleado eliminado con exito"})



if __name__ == "__main__":
    app.run(port=3000, debug=True)