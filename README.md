https://chatgpt.com/share/684079ac-f2fc-8010-aff6-c86b390af518

sudo apt update
sudo apt install ansible sshpass -y

sudo apt update
sudo apt install openssh-server -y
sudo systemctl enable ssh
sudo systemctl start ssh

ssh sushant@172.25.180.222

nano host.ini
[web_servers]
172.25.180.222 ansible_user=sushant ansible_ssh_pass=your_password ansible_become_pass=your_password
trl + O, Enter, Ctrl + X

nano install_apache.yml
---
- name: Install and configure Apache web server
  hosts: web_servers
  become: yes
  tasks:

    - name: Install Apache
      apt:
        name: apache2
        state: present
        update_cache: yes

    - name: Start and enable Apache service
      service:
        name: apache2
        state: started
        enabled: yes

    - name: Ensure Apache homepage is available
      copy:
        content: "<h1>Apache is working!</h1>"
        dest: /var/www/html/index.html
      
**Run**
ansible-playbook -i host.ini install_apache.yml

curl http://172.25.180.222
