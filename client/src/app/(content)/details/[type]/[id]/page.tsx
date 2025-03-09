import { Button } from '@/components/ui/button';
import fetcher from '@/lib/fetcher';
import { Media } from '@/types';

interface Params {
    id: string;
    type: string;
}

export default async function Detail({ params }: { params: Promise<Params> }) {
    const { type, id } = await params;
    const data = (await fetcher(
        `http://${process.env.NEXT_PUBLIC_API_BASE_URL}/api/details/${type}/${id}`,
    )) as Media;

    return (
        <div
            style={{
                background: `linear-gradient(to top, hsl(240, 10%, 3.9%, 1), hsl(240, 10%, 3.9%, 0.1)), url('${data.background}')`,
                backgroundSize: 'cover',
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'center',
            }}
            className="max-w-screen h-[50vh] w-screen md:h-[75vh] md:max-h-[75vh]"
        ></div>
    );
}
