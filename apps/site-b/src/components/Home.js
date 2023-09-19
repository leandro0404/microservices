import { useState, useEffect } from 'react';
import { demo } from '../links/demo';
import { Link } from 'react-router-dom';
import { generateCodeChallenge, generateCodeVerifier } from '../pkce/pkce';

const Home = () => {
    const [demoStr, setDemoStr] = useState('default');

    useEffect(() => {
        const verifier = generateCodeVerifier();
        sessionStorage.setItem('codeVerifier', verifier);
        const codeChallenge = generateCodeChallenge();
        sessionStorage.setItem('codeChallenge', codeChallenge);

        const token = sessionStorage.getItem('id_token');
        const headers = new Headers();
        headers.set('Content-type', 'plain/text');
        headers.set('Authorization', `Bearer ${token}`);
        const url = demo();

        fetch(url, {
            method: 'GET',
            mode: 'cors',
            headers
        }).then(async (demoData) => {
            const demo = await demoData.text();
            // Format the JSON string for display
            const formattedDemo = JSON.stringify(JSON.parse(demo), null, 2);
            setDemoStr(formattedDemo);
        });
    }, []);

    useEffect(() => {
        // Clique no link de login automaticamente quando a página está totalmente carregada
        const handleWindowLoad = () => {
            const loginLink = document.querySelector('a[href="/redirect"]');
            if (loginLink) {
                loginLink.click();
            }
        };

        window.addEventListener('load', handleWindowLoad);

        return () => {
            window.removeEventListener('load', handleWindowLoad);
        };
    }, []);

    return (
        <>
            <div className="header">
                <h1>Home</h1>
                <Link to={'/redirect'}>Login</Link>
            </div>
            <div>
                <pre>{demoStr}</pre>
            </div>
        </>
    );
}

export default Home;
